package com.qzy.laobiao.mine.presenter;

import android.content.Context;

import com.qzy.laobiao.common.UrlConfig;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.manager.ToastManager;
import com.qzy.laobiao.common.net.MyObserver;
import com.qzy.laobiao.common.net.NetWorks;
import com.qzy.laobiao.login.model.UserInfoModel;
import com.qzy.laobiao.mine.impl.MineView;

import java.util.Map;

public class MinePresenter extends BasePresenter {

    //主页回调
    private MineView mineView;

    public MinePresenter(Context context) {
        super(context);
    }

    @Override
    protected void detachView() {
        mineView = null;
    }

    public void setMineView(MineView mineView) {
        this.mineView = mineView;
    }


    /**
     * 个人信息
     */
    public void getMineInfo(final Context context) {
        Map<String, String> map = UrlConfig.getCommonMap();
        map.put("token", BaseApplication.getInstance().getUserId());

        NetWorks.getInstance().getMineInfo(context, map, new MyObserver<UserInfoModel>() {
            @Override
            public void onNext(UserInfoModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
                        mineView.onGetMineInfo(model);
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
}
