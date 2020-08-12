package com.qzy.laobiao.common.base;

import android.os.Bundle;


/**
 * artifact  自定义BaseActivity For MVP
 */
public abstract class BasePresenterFragActivity<T extends BasePresenter> extends BaseFragActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (null != setPresenter()) {
            this.mPresenter = setPresenter();
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }


    /**
     * 此方法必须重写
     * 每个Activity对应一个presenter
     *
     * @return BasePresenter
     */
    protected abstract T setPresenter();

    /**
     * 手动解除view层和presenter层的绑定
     */
    @Override
    protected void onDestroy() {
        if (null != mPresenter) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
