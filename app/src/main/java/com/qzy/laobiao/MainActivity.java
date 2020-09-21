package com.qzy.laobiao;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClient;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.gyf.immersionbar.ImmersionBar;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;
import com.qzy.laobiao.common.manager.ToastManager;
import com.qzy.laobiao.home.impl.HomeView;
import com.qzy.laobiao.home.model.VideoIdModel;
import com.qzy.laobiao.home.presenter.HomePresenter;
import com.qzy.laobiao.home.view.HomeFragment;
import com.qzy.laobiao.hongbao.view.HongbaoFragment;
import com.qzy.laobiao.login.model.FileModel;
import com.qzy.laobiao.login.view.LoginActivity;
import com.qzy.laobiao.mine.view.MineFragment;
import com.qzy.laobiao.msg.view.MessageFragment;
import com.qzy.laobiao.videoCom.DataCreate;
import com.qzy.laobiao.widget.FragmentIndicator;
import com.qzy.laobiao.widget.MenuDialog;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

public class MainActivity extends BasePresenterFragActivity<HomePresenter> implements HomeView, FragmentIndicator.FragmentIndicatorInterface, FragmentIndicator.OnIndicateListener {
    @BindView(R.id.indicator)
    FragmentIndicator indicator;
    @BindView(R.id.video)
    VideoView videoView;
    @BindView(R.id.camera_img)
    ImageView cameraImg;

    //fragment
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private List<Fragment> mFragments;
    private HomeFragment homeFragment;
    private HongbaoFragment hongbaoFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

    private RxPermissions rxPermissions;
    public int mTabTag;

    /**
     * 跳转编辑、录制选择弹窗
     */
    private MenuDialog mMenuDialog;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected HomePresenter setPresenter() {
        //回调
        return new HomePresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        new DataCreate().initData();
        mPresenter.setHomeViewl(this);
        ImmersionBar.with(this).supportActionBar(true).init();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        mFragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        showFragment(homeFragment);

        //设置fragment切换
        indicator.setFragmentIndicatorInterface(this);
        indicator.setOnIndicateListener(this);
        indicator.setIndicator(0);
        //获取存储卡权限
        setRxPermissions();
        rxPermissions = new RxPermissions(context);
        ToastManager.showToast(getApplicationContext(),"啦啦啦啦啦啦啦啦");
    }


    @Override
    public boolean hasLogin() {
        return true;
    }


    @Override
    public void goLogin(int tag) {
        for (Fragment fragment : mFragments) {
            fragment.onPause();
        }
        try {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LoginActivity.class);
            intent.putExtra("tag", tag);
            startActivityForResult(intent, 0);
            //设置切换动画，从右边进入，左边退出
            overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onIndicate(View v, int id) {
        switch (id) {
            case 0:
//                setTransactionToolbar(true);
                mTabTag = 0;
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                showFragment(homeFragment);
                break;
            case 1:
                if (!BaseApplication.getInstance().isLogin()) {
                    goLogin(1);
                    return;
                }
//                setTransactionToolbar(true);
                mTabTag = 1;
                if (hongbaoFragment == null) {
                    hongbaoFragment = new HongbaoFragment();
                }
                showFragment(hongbaoFragment);
                break;
            case 2:
                if (!BaseApplication.getInstance().isLogin()) {
                    goLogin(2);
                    return;
                }
//                setTransactionToolbar(true);
                mTabTag = 2;
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                }
                showFragment(messageFragment);
                break;
            case 3:
                if (!BaseApplication.getInstance().isLogin()) {
                    goLogin(3);
                    return;
                }
//                setTransactionToolbar(true);
                mTabTag = 3;
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                showFragment(mineFragment);
                break;
            case 4:
                if (mMenuDialog == null) {
                    initMenuDialog();
                }
                mMenuDialog.show();
        }
    }

    /**
     * 动态显示Fragment
     *
     * @param showFragment 要增加的fragment
     */
    private void showFragment(Fragment showFragment) {
        if(showFragment == null){
            return;
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        if (!mFragments.contains(showFragment)) {
            mFragments.add(showFragment);
            fragmentTransaction.add(R.id.fragment1, showFragment);
        }
        for (Fragment fragment : mFragments) {
            if (!showFragment.equals(fragment)) {
                fragmentTransaction.hide(fragment);
                fragment.onPause();
            }
        }
        fragmentTransaction.show(showFragment);
        showFragment.onResume();
        fragmentTransaction.commit();
        //友盟
//        MobclickAgent.onEvent(this, showFragment.getClass().getSimpleName(), "menu");
    }

    private void setTransactionToolbar(boolean flag) {

        if (flag) {
            mImmersionBar
                    .statusBarDarkFont(true, 0f)//设置状态栏图片为深色，(如果android 6.0以下就是半透明)
                    .fitsSystemWindows(false)//设置这个是为了防止布局和顶部的状态栏重叠
                    .statusBarColor(R.color.transparent)//自定义颜色
                    .supportActionBar(false) //不支持ActionBar使用
                    .init();
        } else {
            mImmersionBar
                    .statusBarDarkFont(true, 0.2f)//设置状态栏图片为深色，(如果android 6.0以下就是半透明)
                    .fitsSystemWindows(true)//设置这个是为了防止布局和顶部的状态栏重叠
                    .statusBarColor(R.color.white)//自定义颜色
                    .supportActionBar(false) //不支持ActionBar使用
                    .init();
        }
    }

    /**
     * 初始化进入录制、编辑的菜单弹窗
     */
    private void initMenuDialog() {
        mMenuDialog = new MenuDialog(MainActivity.this);
        mMenuDialog.setOnMenuItemClickListener(new MenuDialog.OnMenuItemClickListener() {
            @Override
            public void onEditroClick() {
                //右
            }

            @Override
            public void onRecorderClick() {
                rxPermissions
                        .requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Consumer<Permission>() {
                            @Override
                            public void accept(Permission permission) throws Exception {
                                if (permission.granted) {//同意
                                    goPhotoAlbum();
                                } else if (permission.shouldShowRequestPermissionRationale) {//拒绝未勾选不再提示
                                    ToastManager.showToast(context, "您拒接访问存储权限，同意后方可上传图片");
                                } else {//拒绝并且勾选不再提示
                                    ToastManager.showToast(context, "您拒接访问存储权限，请在设置-应用-" + getString(R.string.app_name) + "-权限中打开存储权限");
                                }
                            }
                        });
            }
        });
    }

    //激活相册操作
    private void goPhotoAlbum() {
        Intent intentPic = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentPic, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (1 == requestCode) {
                Uri uri = Objects.requireNonNull(data).getData();
                String[] arrayOf = {MediaStore.Video.Media.DATA};
                Cursor cursor = this.getContentResolver().query(Objects.requireNonNull(uri), arrayOf, null, null, null);
                if (Objects.requireNonNull(cursor).moveToFirst()) {
                    int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
                    int idindex = cursor.getColumnIndex(BaseColumns._ID);
                    int modifiedindex = cursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED);
                    int durationindex = cursor.getColumnIndex(MediaStore.Video.Media.DURATION);
                    String path = cursor.getString(columnIndex);
                    File file = null;
                    try {
                        file = new File(path);
//                        videoView.setVideoPath(path);
//                        videoView.setMediaController(new MediaController(MainActivity.this));
//                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                            @Override
//                            public void onPrepared(MediaPlayer mp) {
//                                videoView.start();
//                            }
                        mPresenter.getUpLoadImg(context);
//                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                cursor.close();
                Toast.makeText(this, "选取了张照片", Toast.LENGTH_SHORT).show();
            } else if (0 == requestCode) {
                if (data != null) {
                    int tag = data.getIntExtra("tag", -1);
                    if (tag != -1) {
                        mTabTag = tag;
                    }
                    switch (mTabTag) {
                        case 0:
                            if(homeFragment == null){
                                homeFragment = new HomeFragment();
                            }
                            showFragment(homeFragment);
                            mTabTag = 0;
                            break;
                        case 1:
                            if (hongbaoFragment == null) {
                                hongbaoFragment = new HongbaoFragment();
                            }
                            showFragment(hongbaoFragment);
                            mTabTag = 1;
                            break;
                        case 2:
                            if (messageFragment == null) {
                                messageFragment = new MessageFragment();
                            }
                            showFragment(messageFragment);
                            mTabTag = 2;
                            break;
                        case 3:
                            if (mineFragment == null) {
                                mineFragment = new MineFragment();
                            }
                            showFragment(mineFragment);
                            mTabTag = 3;
                            break;
                    }
                }
            }
        }
    }

    //申请存储权限
    @SuppressLint("CheckResult")
    private void setRxPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {//同意

                        } else if (permission.shouldShowRequestPermissionRationale) {//拒绝未勾选不再提示

                        } else {//拒绝并且勾选不再提示

                        }
                    }
                });
    }

    @Override
    public void onGetUploadAddresData(FileModel fileModel) {
        final VODUploadClient uploader = new VODUploadClientImpl(getApplicationContext());
        VODUploadCallback callback = new VODUploadCallback() {
            @Override
            public void onUploadSucceed(UploadFileInfo info) {
                Log.e("-----", "" + "Succeed");
                mPresenter.getUploadVideo(context,info);
            }

            @Override
            public void onUploadFailed(UploadFileInfo info, String code, String message) {
                Log.e("-----", "Failed" + code);
            }

            @Override
            public void onUploadProgress(UploadFileInfo info, long uploadedSize, long totalSize) {
                super.onUploadProgress(info, uploadedSize, totalSize);
            }

            @Override
            public void onUploadTokenExpired() {
                //凭证5分钟过期，过期后需要重新获取
                // 重新刷新上传凭证:RefreshUploadVideo
//                String uploadAuth = aa;
//                uploader.resumeWithAuth(uploadAuth);
                Toast.makeText(MainActivity.this, "凭证过期", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUploadRetry(String code, String message) {
                Toast.makeText(MainActivity.this, "上传开始重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUploadRetryResume() {
                super.onUploadRetryResume();
            }

            @Override
            public void onUploadStarted(UploadFileInfo uploadFileInfo) {
                uploader.setUploadAuthAndAddress(uploadFileInfo, fileModel.getBody().getUploadAuth(), fileModel.getBody().getUploadAddress());
                Log.e("-----", "getUploadAuth=" + fileModel.getBody().getUploadAuth());
                Log.e("-----", "getUploadAddress=" + fileModel.getBody().getUploadAddress());
            }
        };
        uploader.init(callback);
        File file = new File(getExternalCacheDir(), "asdf.mp4");
//        File file = new File(getExternalCacheDir(), "IMG_20200621_170851.jpg");
        Log.e("-----", "file=" + file);
        Log.e("-----", "path=" + file.getPath());
        String filePath = "/storage/emulated/0/DCIM/Camera/asdf.mp4";
        String imagPath = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3448936851,681826596&fm=26&gp=0.jpg";
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle("标题");
        vodInfo.setDesc("内容");
        vodInfo.setCateId(19);
        vodInfo.setCoverUrl(imagPath);
        vodInfo.setFileName("老表你好");
        vodInfo.setFileSize("1151545");

        uploader.setPartSize(1 * 1024 * 1024);
        uploader.addFile(filePath, vodInfo);
        vodInfo.setIsProcess(true);
        uploader.start();
    }

    @Override
    public void onGetUploadVideo(VideoIdModel videoIdModel) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (indicator != null) {
            indicator.setIndicator(mTabTag);
        }
    }
}
