package com.qzy.laobiao.common.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * artifact  toast管理
 */
public class ToastManager {

    private static Toast toast;

    private static void init(Context context) {
        if (toast == null) {
            toast = Toast.makeText(context,"", Toast.LENGTH_SHORT);
        }
        //设置toast居中显示
        toast.setGravity(Gravity.CENTER, 0, 0);
    }

    private static void show(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            toast.setText(msg);
            toast.show();
        }
    }

    public static void showToast(Context context, String msg) {
        init(context);
        show(msg);
    }

    public static synchronized void showToast(Context context, Throwable e) {
        e.printStackTrace();
        init(context);
        StringBuilder msg = new StringBuilder();
        if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
            msg.append("网络连接不稳定");
        } else {
            msg.append("访问错误");
        }
        show(msg.toString());
    }

}
