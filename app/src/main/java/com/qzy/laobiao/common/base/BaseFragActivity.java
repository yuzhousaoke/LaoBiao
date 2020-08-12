package com.qzy.laobiao.common.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.manager.AppLoadingManager;
import com.qzy.laobiao.common.manager.TitleManager;
import com.qzy.laobiao.widget.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * artifact  基本acitivity所有的activity父类，在这里实现一些公共的功能
 * 1，实例化context,Resources,LayoutInflater,TitleManager供子类使用
 */
public abstract class BaseFragActivity extends BaseInputFragActivity {

    private Resources rs;
    protected Activity context;
    private BaseApplication app;

    private LayoutInflater inflater;
    protected TitleManager titleManager;
    private AppLoadingManager appLoadingManager;

    //沉浸式标题栏
    protected ImmersionBar mImmersionBar;

    //onResume刷新
    protected boolean isOnResumeUpdate = false;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        PushAgent.getInstance(this).onAppStart();

        app = BaseApplication.getInstance();
        app.addActivity(this);
        context = this;
        rs = this.getResources();
        inflater = LayoutInflater.from(this);
        titleManager = new TitleManager(this);

        //ButterKnife
        if (getLayoutRes() != 0) {
            setContentView(getLayoutRes());
            unbinder = ButterKnife.bind(this);
        }

        //沉浸式标题栏
        if (enabledImmersionBar()) {
//            initImmersionBar();
        }

        //eventBus
//        if (enableEventBus()) {
//            EventBus.getDefault().register(this);
//        }

        if (enableLoading()) {
            appLoadingManager = new AppLoadingManager(this);
        }

        initView();
    }




    /**
     * 初始化
     *
     */
    protected void initView(){

    }


    /**
     * 返回布局文件
     *
     * @return int
     */
    protected abstract int getLayoutRes();

    /**
     * 是否开启eventBus刷新
     */
    private boolean enableEventBus() {
        return false;
    }

    /**
     * 是否开启加载页面
     */
    private boolean enableLoading() {
        return false;
    }

    /**
     * 是否开启沉浸式标题栏
     **/
    private boolean enabledImmersionBar() {
        return true;
    }

//    private void initImmersionBar() {
//        //在BaseActivity里初始化
//        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f)//设置状态栏图片为深色，(如果android 6.0以下就是半透明)
//                .fitsSystemWindows(true)//设置这个是为了防止布局和顶部的状态栏重叠
////                .statusBarColor(R.color.home_un_check)//自定义颜色
//                .statusBarColor(R.color.white)//自定义颜色
//                .supportActionBar(false) //不支持ActionBar使用
//                .init();
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (mImmersionBar != null)
//            mImmersionBar.destroy();

//        if (enableEventBus())
//            EventBus.getDefault().unregister(this);

        if (getLayoutRes() != 0)
            unbinder.unbind();
    }
}
