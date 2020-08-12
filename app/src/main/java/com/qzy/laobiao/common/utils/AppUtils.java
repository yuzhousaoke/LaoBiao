package com.qzy.laobiao.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

/**
 * 跟App相关的辅助类
 */
public class AppUtils {

    private static final String TAG ="AppUtils";

    private AppUtils() {
        /**cannot be instantiated **/
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }


    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 获取MetaValue
    public static String getMetaValue(Context ct, String metaKey) {
        Bundle metaData = null;
        String metaValue = null;
        if (ct == null || metaKey == null) {
            return null;
        }
        try {
            ApplicationInfo ai = ct.getPackageManager()
                    .getApplicationInfo(ct.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai) {
                metaData = ai.metaData;
            }
            if (null != metaData) {
                metaValue = metaData.getString(metaKey);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
        return metaValue;
    }

    //获取友盟渠道
//    public static String getUMENGCHANNEL(Application application) {
//        String channel = "";
//        PackageManager packageManager = application.getPackageManager();
//        if (packageManager != null) {
//            //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
//            ApplicationInfo applicationInfo;
//            try {
//                applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), PackageManager.GET_META_DATA);
//                channel = applicationInfo.metaData.getString("UMENG_CHANNEL");
//                if (channel == null) {
//                    channel = "";
//                }
//            } catch (NameNotFoundException e) {
//                channel = "";
//                e.printStackTrace();
//            }
//        }
//        return channel;
//    }

    /**
     * 强制关闭软键盘
     */
    public static void hintKbTwo(Activity ac) {
        try {
            InputMethodManager imm = (InputMethodManager) ac.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm.isActive() && ac.getCurrentFocus() != null) {
                if (ac.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(ac.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}