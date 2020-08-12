package com.qzy.laobiao.home.presenter;

import android.content.Context;

import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.qzy.laobiao.common.UrlConfig;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.manager.ToastManager;
import com.qzy.laobiao.common.net.MyObserver;
import com.qzy.laobiao.common.net.NetWorks;
import com.qzy.laobiao.home.bean.OldVideoBean;
import com.qzy.laobiao.home.impl.HomeView;
import com.qzy.laobiao.home.model.VideoIdModel;
import com.qzy.laobiao.login.bean.CreateFlie;
import com.qzy.laobiao.login.model.FileModel;

public class HomePresenter extends BasePresenter {
    private HomeView homeViewl;


    public HomePresenter(Context context) {
        super(context);
    }

    @Override
    protected void detachView() {
        homeViewl = null;
    }

    public void setHomeViewl(HomeView homeViewl) {
        this.homeViewl = homeViewl;
    }

    /**
     * 请求上传凭证
     */
    public void getUpLoadImg(final Context context) {

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
                        homeViewl.onGetUploadAddresData(model);
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
     * 上传视频到本地服务器
     */
    public void getUploadVideo(final Context context, UploadFileInfo uploadFileInfo) {

        OldVideoBean oldVideoBean = new OldVideoBean();
        oldVideoBean.setOriginalVideoId(uploadFileInfo.getVodInfo().getCateId());
        oldVideoBean.setArea("柳州市");
        oldVideoBean.setCoverUrl(uploadFileInfo.getVodInfo().getCoverUrl());
        oldVideoBean.setUploadAddress(uploadFileInfo.getFilePath());
        oldVideoBean.setDescription(uploadFileInfo.getVodInfo().getDesc());
        oldVideoBean.setFileName(uploadFileInfo.getVodInfo().getFileName());
        oldVideoBean.setFileSize(uploadFileInfo.getVodInfo().getFileSize());
        oldVideoBean.setTitle(uploadFileInfo.getVodInfo().getTitle());
        oldVideoBean.setTag("无语");
        oldVideoBean.setLength("1111");



        NetWorks.getInstance().getUploadVideo(context, oldVideoBean, new MyObserver<VideoIdModel>() {
            @Override
            public void onNext(VideoIdModel model) {
                try {
                    if (UrlConfig.RESULT_OK == model.getState()) {
                        homeViewl.onGetUploadVideo(model);
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
