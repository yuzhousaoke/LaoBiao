package com.qzy.laobiao.home.bean;

/**
 * create on 2020-06-03
 * description 视频实体类
 */
public class OldVideoBean {
    /** 城市 */
    private String area;
    /** 封面地址 */
    private String coverUrl;
    /** 视频描述 */
    private String description;
    /** 视频名字 */
    private String fileName;
    /** 视频大小 */
    private String fileSize;
    /** 长度 */
    private String length;
    /** 视频标签 */
    private String tag;
    /** 视频标题 */
    private String title;
    /** 上传地址 */
    private String uploadAddress;
    /** id */
    private int originalVideoId;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploadAddress() {
        return uploadAddress;
    }

    public void setUploadAddress(String uploadAddress) {
        this.uploadAddress = uploadAddress;
    }

    public int getOriginalVideoId() {
        return originalVideoId;
    }

    public void setOriginalVideoId(int originalVideoId) {
        this.originalVideoId = originalVideoId;
    }


}
