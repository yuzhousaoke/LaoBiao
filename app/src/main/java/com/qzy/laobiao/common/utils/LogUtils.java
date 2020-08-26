package com.qzy.laobiao.common.utils;

import android.util.Log;

/**
 * artifact  Log日志管理工具
 */
public class LogUtils {

    /**
     * 是否需要打印Log 默认输出（除了release模式）
     */
    public static boolean IS_DEBUG;


    private static final String TAG = "老表短视频";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (IS_DEBUG)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (IS_DEBUG)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (IS_DEBUG)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (IS_DEBUG)
            Log.v(TAG, msg);
    }

    // 下面是传入类名打印log
    public static void i(Class<?> _class, String msg) {
        if (IS_DEBUG)
            Log.i(_class.getName(), msg);
    }

    public static void d(Class<?> _class, String msg) {
        if (IS_DEBUG)
            Log.i(_class.getName(), msg);
    }

    public static void e(Class<?> _class, String msg) {
        if (IS_DEBUG)
            Log.i(_class.getName(), msg);
    }

    public static void v(Class<?> _class, String msg) {
        if (IS_DEBUG)
            Log.i(_class.getName(), msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (IS_DEBUG)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (IS_DEBUG)
            Log.i(tag, msg);
    }

}
