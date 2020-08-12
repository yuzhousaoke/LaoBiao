package com.qzy.laobiao.common.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import com.qzy.laobiao.common.manager.AppLoadingManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * artifact  基本Fragment所有的activity父类，在这里实现一些公共的功能
 * 1，实例化context,Resources,LayoutInflater,TitleManager供子类使用
 * 2，创建公共方法
 */
public class BaseFragment extends LazyFragment {

    private BaseApplication app;
    protected Resources rs;
    private LayoutInflater inflater;
    protected Activity context;

    private View mRootView;
    protected AppLoadingManager loadingManager;

    protected boolean isOnResumeUpdate = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    protected boolean enableEventBus() {
        return false;
    }


    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        app = BaseApplication.getInstance();
        rs = this.getResources();
        this.inflater = inflater;

//        if (enableEventBus()) {
//            EventBus.getDefault().register(this);
//        }

        if (getLayoutRes() != 0) {
            mRootView = inflater.inflate(getLayoutRes(), container, false);
            unbinder = ButterKnife.bind(this, mRootView);//绑定framgent

            initView();
            if (enableLoading()) {
                loadingManager = new AppLoadingManager(context, mRootView);
            }
            return mRootView;
        } else {
            initView();
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    /**
     * 返回布局文件
     *
     * @return int
     */
    protected int getLayoutRes() {
        return 0;
    }

    protected void initView() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        if (enableEventBus()) {
//            EventBus.getDefault().unregister(this);
//        }
        if (getLayoutRes() != 0) {
            unbinder.unbind();
        }
    }

    /**
     * 是否开启加载页面
     */
    protected boolean enableLoading() {
        return false;
    }

    @Override
    protected void lazyLoad() {

    }


}
