package com.qzy.laobiao.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.utils.StringUtils;


/**
 * @Author：Administrator 2017/11/14 0014 下午 4:47
 * artifact  自定义弹框
 */
public class CommonAlertDialog {

    private Context context;
    private Display display;

    private Dialog mDialog;
    private View view;

    private LinearLayout layout;
    private TextView msgTv, cutTv;
    private Button cancelBtn, sureBtn;


    public CommonAlertDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public CommonAlertDialog builder() {
        // 获取Dialog布局
        view = LayoutInflater.from(context).inflate(R.layout.dialog_alert, null);

        // 获取自定义Dialog布局中的控件
        layout = view.findViewById(R.id.dialog_layout);
        msgTv = view.findViewById(R.id.msg_tv);
        cancelBtn = view.findViewById(R.id.cancel_btn);
        sureBtn = view.findViewById(R.id.sure_btn);
        cutTv = view.findViewById(R.id.cut_tv);

        // 定义Dialog布局和参数
        mDialog = new Dialog(context, R.style.AlertDialogStyle);
        mDialog.setContentView(view);
        Point point = new Point();
        display.getSize(point);
        // 调整dialog背景大小
        layout.setLayoutParams(new FrameLayout.LayoutParams((int) (point.x * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }


    /**
     * 设置msg内容
     *
     * @param msg
     * @return
     */
    public CommonAlertDialog setMsg(String msg) {
        if (StringUtils.isEmpty(msg)) {
            msgTv.setText("内容");
        } else {
            msgTv.setText(msg);
        }
        return this;
    }

    /**
     * 获取msg内容
     *
     * @return
     */
    public String getMsg() {
        if (msgTv != null) {
            return msgTv.getText().toString();
        }
        return "";
    }


    /**
     * 右边确定按钮监听
     *
     * @param text
     * @param listener
     * @return
     */
    public CommonAlertDialog setPositiveButton(String text, final View.OnClickListener listener) {
        if (!StringUtils.isEmpty(text)) {
            sureBtn.setText(text);
        }
        sureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
        return this;
    }

    /**
     * 左边取消按钮监听,默认显示文字为取消，用户可以根据自定义显示文字
     *
     * @param text
     * @param listener
     * @return
     */
    public CommonAlertDialog setNegativeButton(String text, final View.OnClickListener listener) {
        if (!StringUtils.isEmpty(text)) {
            cancelBtn.setText(text);
        }
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                mDialog.dismiss();
            }
        });
        return this;
    }


    /**
     * 取消按钮
     */
    public void hideCancleBtn() {
        cancelBtn.setVisibility(View.GONE);
        cutTv.setVisibility(View.GONE);
    }

    /**
     * 显示对话框
     */
    public void show() {
        mDialog.show();
    }

    /**
     * 取消显示对话框
     */
    public void dismiss() {
        mDialog.dismiss();
    }
}
