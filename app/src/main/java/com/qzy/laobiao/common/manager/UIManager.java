package com.qzy.laobiao.common.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;


import com.qzy.laobiao.R;

import java.io.Serializable;
import java.util.Map;

/**
 * artifact  界面跳转管理类
 */
public class UIManager {

    /**
     * Activity不带数据的跳转
     *
     * @param context
     * @param cls
     */
    public static void switcher(Context context, Class<?> cls) {
        try {
            Intent intent = new Intent();
            intent.setClass(context, cls);
            context.startActivity(intent);
            //设置切换动画，从右边进入，左边退出
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从下往上
     *
     * @param context
     * @param cls
     */
    public static void switcherBottom(Context context, Map<String, Object> map, Class<?> cls) {
        try {
            Intent intent = new Intent();
            putExtraData(map, intent);
            intent.setClass(context, cls);
            context.startActivity(intent);
            //设置切换动画，从下往上,从上往下
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.in_bottom, R.anim.silent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Activity带有数据跳转
     *
     * @param context
     * @param map
     * @param cls
     */
    public static void switcher(Context context, Map<String, Object> map, Class<?> cls) {
        Intent intent = new Intent();
        putExtraData(map, intent);
        intent.setClass(context, cls);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
        }
    }

    /**
     * Activity带返回值的跳转
     *
     * @param context
     * @param cls
     */
    public static void switcher(Activity context, Class<?> cls, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivityForResult(intent, requestCode);
        //设置切换动画，从右边进入，左边退出
        context.overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    /**
     * Activity带有数据并且有返回值的跳转
     *
     * @param context
     * @param map
     * @param cls
     */
    public static void switcher(Activity context, Map<String, Object> map, Class<?> cls, int requestCode) {
        Intent intent = new Intent();
        putExtraData(map, intent);
        intent.setClass(context, cls);
        context.startActivityForResult(intent, requestCode);
        //设置切换动画，从右边进入，左边退出
        context.overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    /**
     * 添加数据
     *
     * @param map    Map<String, Object>
     * @param intent Intent
     */
    private static void putExtraData(Map<String, Object> map, Intent intent) {
        if (map != null) {
            for (String key : map.keySet()) {
                Object value = map.get(key);
                if (value instanceof Integer) {
                    intent.putExtra(key, (Integer) value);
                } else if (value instanceof String) {
                    intent.putExtra(key, (String) value);
                } else if (value instanceof Double) {
                    intent.putExtra(key, (Double) value);
                } else if (value instanceof Float) {
                    intent.putExtra(key, (Float) value);
                } else if (value instanceof Long) {
                    intent.putExtra(key, (Long) value);
                } else if (value instanceof Boolean) {
                    intent.putExtra(key, (Boolean) value);
                } else if (value instanceof Parcelable) {
                    intent.putExtra(key, (Parcelable) value);
                } else if (value instanceof Serializable) {
                    intent.putExtra(key, (Serializable) value);
                }
            }
        }
    }
}
