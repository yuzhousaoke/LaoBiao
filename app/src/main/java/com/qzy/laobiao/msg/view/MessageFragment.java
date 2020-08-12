package com.qzy.laobiao.msg.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;

import butterknife.BindView;

/**
 *
 * 消息fragment
 */
public class MessageFragment extends BasePresenterFragment {

    @BindView(R.id.title_txt)
    TextView title_txt;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {
        super.initView();
        title_txt.setText("消息");
    }
}
