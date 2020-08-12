package com.qzy.laobiao.common.net;

import android.text.TextUtils;
import android.util.Log;


import com.qzy.laobiao.common.UrlConfig;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.utils.LogUtils;
import com.qzy.laobiao.common.utils.RxUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Description:OkHttp3Utils
 */

class OkHttp3Utils {
    private static OkHttpClient mOkHttpClient;
    // 设置缓存目录
    private static File cacheDir = new File(UrlConfig.getFileRootPath(), "cache");
    private static Cache cache = new Cache(cacheDir, 400 * 1024 * 1024);//200M
    private static final long TIME_OUT = 8;

    static OkHttpClient getOkHttpClient() {


        Interceptor tokenInterceptor = new Interceptor() {//全局拦截器，往请求头部添加 token 字段，实现了全局添加 token
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();//获取请求
                Request tokenRequest = null;
                if (TextUtils.isEmpty(BaseApplication.getInstance().getUserId())) {//对 token 进行判空，如果为空，则不进行修改
                    return chain.proceed(originalRequest);
                }
                tokenRequest = originalRequest.newBuilder()//往请求头中添加 token 字段
                        .header("token", BaseApplication.getInstance().getUserId())
                        .build();
                return chain.proceed(tokenRequest);
            }

        };

        ///
        //添加日志打印
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

            @Override
            public void log(String message) {
                LogUtils.i(message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);


        //当服务器返回的状态码为401时，会自动执行里面的代码，也就实现了自动刷新token
        Authenticator authenticator = new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                LogUtils.e("==========>   重新刷新了token");//这里可以进行刷新 token 的操作
//                instance.getUploadToken()
                return response.request().newBuilder()
                        .addHeader("token", "")
                        .build();
            }
        };


        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cookieJar(new CookiesManager(BaseApplication.getInstance().getApplicationContext()))
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .cache(cache)
                    .addInterceptor(logInterceptor)//使用上面的拦截器
                    .addInterceptor(chain -> {
                        Request original = chain.request();

                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder()
                                .addHeader("Authorization",BaseApplication.getInstance().getUserId());


                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    })
                    .retryOnConnectionFailure(true)
                    .addNetworkInterceptor(tokenInterceptor)
                    .sslSocketFactory(RxUtils.createSSLSocketFactory(), new RxUtils.TrustAllManager())
                    .hostnameVerifier(new RxUtils.TrustAllHostnameVerifier())
                    .build();
        }


        return mOkHttpClient;
    }


}
