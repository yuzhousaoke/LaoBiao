package com.qzy.laobiao.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


/**
 * artifact  自定义BaseFragment FOR MVP
 */
public class BasePresenterFragment<T extends BasePresenter> extends BaseFragment {

    protected T mPresenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != setPresenter()) {
            this.mPresenter = setPresenter();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        //统计页面，"MainScreen"为页面名称，可自定义
//        MobclickAgent.onPageStart(getClass().getName());
    }

    public void onPause() {
        super.onPause();
        //友盟
//        MobclickAgent.onPageEnd(getClass().getName());
    }

    /**
     * 此方法必须重写
     * 每个Fragment对应一个presenter
     *
     * @return BasePresenter
     */
    protected T setPresenter() {
        return null;
    }


    @Override
    public void onDestroyView() {
        if (null != mPresenter) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
