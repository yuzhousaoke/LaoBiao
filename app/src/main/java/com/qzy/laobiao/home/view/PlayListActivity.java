package com.qzy.laobiao.home.view;


import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BaseActivity;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;
import com.qzy.laobiao.common.base.BasePresenterFragment;

public class PlayListActivity extends BasePresenterFragActivity {
    public static int initPos;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_play_list;
    }

    @Override
    protected void initView() {
        super.initView();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, new LocalVideoFragment()).commit();
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }
}
