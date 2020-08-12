package com.qzy.laobiao.home.impl;

import com.qzy.laobiao.home.model.VideoIdModel;
import com.qzy.laobiao.login.model.FileModel;

public interface HomeView {
    void onGetUploadAddresData(FileModel fileModel);

    void onGetUploadVideo(VideoIdModel videoIdModel);
}
