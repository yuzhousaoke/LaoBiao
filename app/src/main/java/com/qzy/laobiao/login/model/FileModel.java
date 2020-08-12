package com.qzy.laobiao.login.model;


import com.qzy.laobiao.common.base.BaseModel;

public class FileModel extends BaseModel {
    private OilTime body;

    public OilTime getBody() {
        return body;
    }

    public void setBody(OilTime body) {
        this.body = body;
    }

    public class OilTime {
        private String requestId;
        private String videoId;
        private String uploadAddress;
        private String uploadAuth;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getUploadAddress() {
            return uploadAddress;
        }

        public void setUploadAddress(String uploadAddress) {
            this.uploadAddress = uploadAddress;
        }

        public String getUploadAuth() {
            return uploadAuth;
        }

        public void setUploadAuth(String uploadAuth) {
            this.uploadAuth = uploadAuth;
        }
    }

}
