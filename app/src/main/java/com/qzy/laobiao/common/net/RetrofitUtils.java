package com.qzy.laobiao.common.net;



import com.qzy.laobiao.common.ServiceConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * artifact  Retrofit管理类
 */

class RetrofitUtils {

    private static Retrofit mRetrofit;

    private static OkHttpClient mOkHttpClient;

    static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            if (mOkHttpClient == null) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ServiceConfig.getRootUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
            NetService api = mRetrofit.create(NetService.class);
        }
        return mRetrofit;
    }
}
