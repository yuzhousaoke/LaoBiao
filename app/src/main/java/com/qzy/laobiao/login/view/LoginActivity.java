package com.qzy.laobiao.login.view;


import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClient;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.gyf.immersionbar.ImmersionBar;
import com.qzy.laobiao.MainActivity;
import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.base.BasePresenterActivity;
import com.qzy.laobiao.common.manager.ToastManager;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.common.utils.StatusBarUtils;
import com.qzy.laobiao.common.utils.StringUtils;
import com.qzy.laobiao.login.impl.LoginView;
import com.qzy.laobiao.login.impl.UploadAddresView;
import com.qzy.laobiao.login.model.FileModel;
import com.qzy.laobiao.login.model.LoginModel;
import com.qzy.laobiao.login.presenter.LoginPresenter;
import com.qzy.laobiao.widget.ClearEditText;
import com.qzy.laobiao.widget.CountDownButton;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import pub.devrel.easypermissions.EasyPermissions;


public class LoginActivity extends BasePresenterActivity<LoginPresenter> implements LoginView, UploadAddresView, EasyPermissions.PermissionCallbacks {
    private Button get_code_btn, login_btn;
    private ClearEditText phone, yzcode;
    private ImageView imageView;
    private TextView register;
    private String getCode;

    private String city = "柳州";


    /**
     * 所要申请的权限
     */
    String[] perms = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,

    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;


    private final int READ_CODE = 10;
    private int mTag = -1;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter(this);
    }


    @Override
    protected void initView() {
        super.initView();
        ImmersionBar.with(this).init();
        mPresenter.setLoginView(this);
        mPresenter.setUploadAddresView(this);
        StatusBarUtils.setTranslucentStatus(context);
        //定位
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this
                    , "必要的权限"
                    , 0
                    , perms);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            System.out.println("ok");
        } else {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        }
        phone = findViewById(R.id.iphnone);
        yzcode = findViewById(R.id.yzcode);
        get_code_btn = findViewById(R.id.get_code_btn);
        register = findViewById(R.id.register);
        imageView = findViewById(R.id.home_imag);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("city", city);
                UIManager.switcher(LoginActivity.this,map, MainActivity.class);
                finish();
//                goPhotoAlbum();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isEmpty(Objects.requireNonNull(phone.getText()).toString().trim()) || phone.getText().toString().trim().length() != 11) {
                    ToastManager.showToast(context, "请输入正确的手机号码");
                    return;
                }
                if (StringUtils.isEmpty(Objects.requireNonNull(yzcode.getText()).toString())) {
                    ToastManager.showToast(context, "请输入验证码");
                    return;
                } else {
                    mPresenter.goRegister(context, "柳州", phone.getText().toString().trim(), yzcode.getText().toString().trim());
                }
            }
        });
        get_code_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isEmpty(Objects.requireNonNull(phone.getText()).toString().trim()) || phone.getText().toString().trim().length() != 11) {
                    ToastManager.showToast(context, "请输入正确的手机号码");
                    return;
                }
                CountDownButton btn = new CountDownButton(60000, 1000, LoginActivity.this, get_code_btn, 1);
                btn.start();
                mPresenter.sendCode(context, phone.getText().toString().trim(), get_code_btn);
            }
        });
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isEmpty(Objects.requireNonNull(phone.getText()).toString().trim()) || phone.getText().toString().trim().length() != 11) {
                    ToastManager.showToast(context, "请输入正确的手机号码");
                    return;
                }
                if (StringUtils.isEmpty(Objects.requireNonNull(yzcode.getText()).toString())) {
                    ToastManager.showToast(context, "请输入验证码");
                    return;
                } else {
//                    UIManager.switcher(LoginActivity.this, VideoListActivity.class);
                    mPresenter.goLogin(context, city, phone.getText().toString().trim(), yzcode.getText().toString().trim());
                }
            }
        });
        if (getIntent() != null) {
            mTag = getIntent().getIntExtra("tag", -1);
        }
    }

    private void initAliyunPlayerView() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    //激活相册操作
    private void goPhotoAlbum() {
//        Intent intent = new Intent();
//        intent.setType("video/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, 1);

        Intent intentPic = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentPic, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            assert uri != null;
            Cursor cursor = cr.query(uri, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    // 视频ID:MediaStore.Audio.Media._ID
                    int videoId = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
                    // 视频名称：MediaStore.Audio.Media.TITLE
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
                    // 视频路径：MediaStore.Audio.Media.DATA
                    String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                    Log.e("size ", path + "");
                    // 视频时长：MediaStore.Audio.Media.DURATION
                    int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
                    // 视频大小：MediaStore.Audio.Media.SIZE
                    long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                    Log.e("size ", size + "");
                    // 视频缩略图路径：MediaStore.Images.Media.DATA
                    String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                    // 缩略图ID:MediaStore.Audio.Media._ID
                    int imageId = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
                    String videoUrl1 = "/storage/emulated/0/DCIM/Camera/asdf.mp4";
                    mPresenter.getUpLoadImg(context, title + ".mp4", size);
                }
                cursor.close();
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @Override
    public void onGetLoginData(LoginModel model) {
        BaseApplication.getInstance().setUserId(model.getBody());
//        mPresenter.getUserInfo(context,2);
//        UIManager.switcher(context, MainActivity.class);
        ToastManager.showToast(context, "登陆成功");
        Intent data = new Intent();
        data.putExtra("tag", mTag);
        setResult(Activity.RESULT_OK, data);
        finish();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onGetUploadAddresData(FileModel fileModel) {
        final VODUploadClient uploader = new VODUploadClientImpl(getApplicationContext());
        VODUploadCallback callback = new VODUploadCallback() {
            @Override
            public void onUploadSucceed(UploadFileInfo info) {
                Log.e("-----", "" + "Succeed");
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
                Toast.makeText(LoginActivity.this, "凭证过期", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUploadRetry(String code, String message) {
                Toast.makeText(LoginActivity.this, "上传开始重试", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(LoginActivity.this, "开始上传回调", Toast.LENGTH_SHORT).show();
            }
        };
        uploader.init(callback);
        File file = new File(getExternalCacheDir(), "asdf.mp4");
//        File file = new File(getExternalCacheDir(), "IMG_20200621_170851.jpg");
        Log.e("-----", "file=" + file);
        Log.e("-----", "path=" + file.getPath());
        String filePath = "/storage/emulated/0/DCIM/Camera/asdf.mp4";
//        String filePath = "/storage/emulated/0/DCIM/Camera/IMG_20200621_170851.jpg";
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle("标题");
        vodInfo.setDesc("内容");
        vodInfo.setCateId(19);
        uploader.setPartSize(1 * 1024 * 1024);
        vodInfo.setIsProcess(true);
        uploader.addFile(filePath, vodInfo);
        uploader.start();
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}

