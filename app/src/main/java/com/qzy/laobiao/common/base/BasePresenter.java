package com.qzy.laobiao.common.base;

import android.content.Context;


/**
 * artifact  presenter 层基类
 */
public abstract class BasePresenter {

    protected Context context;

    protected BasePresenter(Context context) {
        this.context = context;
    }

    /**
     * 解除view层和presenter的绑定
     * 在BasePresenterFragment的onDestroyView()方法和BasePresenterActivity的onDestroy()方法里默认调用
     * 每个Fragment和Activity只需继承对应的base类即可
     * 并且在子类presenter中逐一解绑所有的view
     */
    protected abstract void detachView();
}
