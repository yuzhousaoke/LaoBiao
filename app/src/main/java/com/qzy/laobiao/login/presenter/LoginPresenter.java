package com.qzy.laobiao.login.presenter;


import android.content.Context;
import android.widget.Button;

import com.qzy.laobiao.MainActivity;
import com.qzy.laobiao.common.UrlConfig;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.manager.ToastManager;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.common.net.MyObserver;
import com.qzy.laobiao.common.net.NetWorks;
import com.qzy.laobiao.login.bean.CreateFlie;
import com.qzy.laobiao.login.bean.User;
import com.qzy.laobiao.login.bean.UserToken;
import com.qzy.laobiao.login.bean.YzCode;
import com.qzy.laobiao.login.impl.LoginView;
import com.qzy.laobiao.login.impl.UploadAddresView;
import com.qzy.laobiao.login.model.FileModel;
import com.qzy.laobiao.login.model.LoginModel;
import com.qzy.laobiao.login.model.UserInfoModel;
import com.qzy.laobiao.login.model.YzCodeModel;
import com.qzy.laobiao.widget.CountDownButton;

import java.util.Map;

/**
 * artifact  登录业务操作
 */
public class LoginPresenter extends BasePresenter {

    private LoginView loginView;

    private UploadAddresView uploadAddresView;

    public LoginPresenter(Context context) {
        super(context);
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setUploadAddresView(UploadAddresView uploadAddresView) {
        this.uploadAddresView = uploadAddresView;
    }

    @Override
    protected void detachView() {
        loginView = null;
    }

    /**
     * 登录
     *
     * @param context  上下文
     * @param mobile     用户名
     * @param verifyCode 密码
     */
    public void goLogin(final Context context, String area, String mobile, String verifyCode) {
        User user = new User();
        user.setArea(area);
        user.setMobile(mobile);
        user.setVerifyCode(verifyCode);

        NetWorks.getInstance().goLogin(context, user, new MyObserver<LoginModel>() {
            @Override
            public void onNext(LoginModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
                        loginView.onGetLoginData(model);
//                        UIManager.switcher(context, VideoListActivity.class);
                        ToastManager.showToast(context, "登陆成功");
                    } else {
                        ToastManager.showToast(context, model.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastManager.showToast(context, e);
            }
        });

    }

    /**
     * 注册
     *
     * @param context 上下文
     * @param mobile   手机号
     * @param verifyCode     验证码
     */
    public void goRegister(final Context context, String area, String mobile, String verifyCode) {
        User user = new User();
        user.setMobile(mobile);
        user.setVerifyCode(verifyCode);
        user.setArea(area);

        NetWorks.getInstance().getRegister(context, user, new MyObserver<LoginModel>() {
            @Override
            public void onNext(LoginModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
//                        loginView.onGetLoginData(model);
                        UIManager.switcher(context, MainActivity.class);
                        ToastManager.showToast(context, "注册成功");
                    } else {
                        ToastManager.showToast(context, model.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastManager.showToast(context, e);
            }
        });

    }


    /**
     * 发送注册短信
     *
     * @param context 上下文
     * @param phone   手机号
     */
    public void sendCode(final Context context, String phone, final Button get_code_btn) {
        YzCode yzCode = new YzCode();
        yzCode.setMobile(phone);

        NetWorks.getInstance().checkPhoneCode(context, yzCode, new MyObserver<YzCodeModel>() {
            @Override
            public void onNext(YzCodeModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
                        CountDownButton btn = new CountDownButton(60000, 1000, context, get_code_btn, 1);
                        btn.start();
                        ToastManager.showToast(context, model.getMsg());
                    } else {
                        ToastManager.showToast(context, model.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastManager.showToast(context, e);
            }
        });
    }

    /**
     * 创建唯一文件名
     */
    public void getUpLoadImg(final Context context,String file,long size) {

        CreateFlie createFlie = new CreateFlie();
        createFlie.setDescription("file");
        createFlie.setFileName("sssssssss.mp4");
        createFlie.setFileSize(10000);
        createFlie.setTitle("111111");

        NetWorks.getInstance().getFile(context, createFlie, new MyObserver<FileModel>() {
            @Override
            public void onNext(FileModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
                        uploadAddresView.onGetUploadAddresData(model);
                    } else {
                        ToastManager.showToast(context, model.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastManager.showToast(context, e);
            }
        });
    }



//    /**
//     * 获取用户信息
//     */
//    public void getUserInfo(final Context context,int code) {
//
//        Map<String, String> map = UrlConfig.getCommonMap();
//        map.put("token", BaseApplication.getInstance().getUserId());
//
//        NetWorks.getInstance().getUserInfo(context, map,new MyObserver<UserInfoModel>() {
//            @Override
//            public void onNext(UserInfoModel model) {
//                try {
//                    if (UrlConfig.RESULT_OK == model.getState()) {
//                        ToastManager.showToast(context, model.getMsg());
//                    } else {
//                        ToastManager.showToast(context, model.getMsg());
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                ToastManager.showToast(context, e);
//            }
//        });
//    }


}
