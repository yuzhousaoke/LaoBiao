package com.qzy.laobiao.mine.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyVideoFragment extends BasePresenterFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_video;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    public static MyVideoFragment newInstance(int s) {
        MyVideoFragment newFragment = new MyVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("flag", s);
        newFragment.setArguments(bundle);
        return newFragment;
    }
}
