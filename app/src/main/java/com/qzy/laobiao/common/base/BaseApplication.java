package com.qzy.laobiao.common.base;

import android.app.Application;


import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.qzy.laobiao.common.ServiceConfig;
import com.qzy.laobiao.common.UrlConfig;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.common.net.PersistentCookieStore;
import com.qzy.laobiao.common.utils.AppUtils;
import com.qzy.laobiao.common.utils.SpUtils;
import com.qzy.laobiao.common.utils.StringUtils;
import com.qzy.laobiao.login.view.LoginActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * artifact  BaseApplication
 */
public class BaseApplication extends Application {

    // 创建application对象
    private static BaseApplication mInstance;

    //Activity栈保存打开的activity，退出时关闭所有的activity
    private List<Activity> mList = new LinkedList<>();

    //UserId根据userId获取用户信息
    private String userId = "";
    //手机号
    private String phone = "";
    //app版本
    public String AppVersion = "";
    //渠道名称
    public String channelName = "";

    public void onCreate() {
        super.onCreate();
        mInstance = this;

        AppVersion = AppUtils.getVersionName(this);
//        channelName = AppUtils.getUMENGCHANNEL(mInstance);

        //友盟统计，分享
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, UrlConfig.UMENG_SECRET);

        //普通统计场景
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        //可以理解为页面时长统计和页面名字统计分离
//        MobclickAgent.openActivityDurationTrack(false);
        ServiceConfig.getRootUrl();
        //平方字体
        //TypefaceUtil.replaceSystemDefaultFont(this,"fonts/pingfangregular.ttf");
//        initUMengShare();
//        initUMengPush();
    }

//    /**
//     * 分享
//     */
//    private void initUMengShare() {
//        //初始化分享sdk
//        UMShareAPI.get(this);
//        //微信
//        PlatformConfig.setWeixin(UrlConfig.UMENG_SHARE_WX_ID, UrlConfig.UMENG_SHARE_WX_KEY);
//        //QQ
//        PlatformConfig.setQQZone(UrlConfig.UMENG_SHARE_QQ_ID, UrlConfig.UMENG_SHARE_QQ_KEY);
//    }

    /**
     * 推送
     **/
//    @SuppressLint("HardwareIds")
//    private void initUMengPush() {
//        //获取消息推送代理示例
//        final PushAgent mPushAgent = PushAgent.getInstance(this);
//
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
//                LogUtils.i("注册成功：deviceToken：-------->  " + deviceToken);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                LogUtils.i("注册失败：-------->  " + "s:" + s + ",s1:" + s1);
//            }
//        });

//        UmengMessageHandler messageHandler = new UmengMessageHandler() {

            /**
             * 自定义通知栏样式的回调方法
             */
//            @Override
//            @SuppressWarnings("deprecation")
//            public Notification getNotification(Context context, UMessage msg) {
//                switch (msg.builder_id) {
//                    case 1:
//                        Notification.Builder builder;
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                            builder = new Notification.Builder(context, "1");
//                        } else {
//                            builder = new Notification.Builder(context);
//                        }
//                        RemoteViews myNotificationView = new RemoteViews(context.getPackageName(),
//                                R.layout.notification_view);
//                        myNotificationView.setTextViewText(R.id.notification_title, msg.title);
//                        myNotificationView.setTextViewText(R.id.notification_text, msg.text);
//                        myNotificationView.setImageViewBitmap(R.id.notification_large_icon, getLargeIcon(context, msg));
//                        myNotificationView.setImageViewResource(R.id.notification_small_icon,
//                                getSmallIconId(context, msg));
//                        builder.setContent(myNotificationView)
//                                .setSmallIcon(getSmallIconId(context, msg))
//                                .setTicker(msg.ticker)
//                                .setAutoCancel(true);
//
//                        return builder.build();
//                    default:
//                        //默认为0，若填写的builder_id并不存在，也使用默认。
//                        return super.getNotification(context, msg);
//                }
//            }
//        };
//        mPushAgent.setMessageHandler(messageHandler);
//
//        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
//            @Override
//            public void dealWithCustomAction(Context context, UMessage msg) {
//                LogUtils.i("umeng推送：--------> click ");
//            }
//
//        };
//
//        mPushAgent.setNotificationClickHandler(notificationClickHandler);
//
//    }

    /**
     * 创建application便于没有application的类中调用
     *
     * @return BaseApplication
     */
    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    /**
     * 注销账户 -- 清除账号
     * 跳转登录界面
     */
    public void exitLogin(Context context) {
        setUserId("");
        setAccount("");
        try {
            PersistentCookieStore.clearCookie();//本地cookie清空
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.switcher(context, LoginActivity.class);
    }

    /**
     * 注销账户 -- 清楚账号
     * 跳转登录界面
     */
    public void exitTokenLogin(Context context) {
        setUserId("");
        try {
            PersistentCookieStore.clearCookie();//本地cookie清空
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.switcher(context, LoginActivity.class);
    }

    //退出APP
    public void exitApp() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    /**
     * 获取userId
     */
    public String getUserId() {
        if (!StringUtils.isEmpty(userId)) {
            return userId;
        } else {
            return (String) SpUtils.get(getApplicationContext(), UrlConfig.USERID, "");
        }
    }

    /**
     * 设置userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
        SpUtils.put(getApplicationContext(), UrlConfig.USERID, null == userId ? "" : userId);
        Log.e("Test", userId);
    }

    /**
     * 获取账号
     */
    public String getAccount() {
        if (!StringUtils.isEmpty(phone)) {
            return phone;
        } else {
            return (String) SpUtils.get(getApplicationContext(), UrlConfig.ACCOUNT, "");
        }
    }


    /**
     * 设置账号
     */
    public void setAccount(String phone) {
        this.phone = phone;
        SpUtils.put(getApplicationContext(), UrlConfig.ACCOUNT, null == phone ? "" : phone);
    }

    /**
     * 判断用户是否登录
     * true已登录  false未登录
     */
    public boolean isLogin() {
        return !StringUtils.isEmpty(getUserId());
    }

    //add activity
    public void addActivity(Activity activity) {
        if (mList != null) {
            mList.add(activity);
        }
    }








}

