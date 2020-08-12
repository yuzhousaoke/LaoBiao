package com.qzy.laobiao.login.model;


import com.qzy.laobiao.common.base.BaseModel;

/**
 * artifact
 */

public class LoginModel extends BaseModel {
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LoginModel() {
    }

    public LoginModel(String body) {
        this.body = body;
    }
}
