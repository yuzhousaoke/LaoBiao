package com.qzy.laobiao.common.base;

import android.os.Bundle;


/**
 * artifact  自定义BaseActivity For MVP
 */
public abstract class BasePresenterActivity<T extends BasePresenter> extends BaseActivity {

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
        //统计页面(仅有Activity的应用中SDK自动调用，不需要单独写。"SplashScreen"为页面名称，可自定义)
        //友盟
//        MobclickAgent.onPageStart(getClass().getName());
        //统计时长
//        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // （仅有Activity的应用中SDK自动调用，不需要单独写）保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息。"SplashScreen"为页面名称，可自定义
        //友盟
//        MobclickAgent.onPageEnd(getClass().getName());
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
