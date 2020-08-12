package com.qzy.laobiao.widget;


import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.qzy.laobiao.R;


public class CountDownButton extends CountDownTimer {

    private Button bn;
    private Context context;
    private int flag;

    /**
     * @param millisInFuture    读秒时间
     * @param countDownInterval 每countDownInterval的时间执行onTick,更新
     */
    public CountDownButton(long millisInFuture, long countDownInterval, Context context, Button btn, int flag) {
        super(millisInFuture, countDownInterval);
        this.bn = btn;
        this.context = context;
        this.flag = flag;
    }


    @Override
    public void onTick(long millisUntilFinished) {
        bn.setText(millisUntilFinished / 1000 + "s");
        bn.setEnabled(false);
        //bn.setTextColor(ContextCompat.getColor(R.color.text_color_light_gray));
        bn.setTextColor(ContextCompat.getColor(context, R.color.text_color_light_gray));
    }

    @Override
    public void onFinish() {
        bn.setText("重新获取");
        bn.setEnabled(true);

//        if (flag == 1) {
//            bn.setTextColor(ContextCompat.getColor(context,R.color.login_blue1));
//        } else {
//            bn.setTextColor(ContextCompat.getColor(context,R.color.login_orange));
//        }

    }

}

