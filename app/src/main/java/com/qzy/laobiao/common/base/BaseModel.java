package com.qzy.laobiao.common.base;


/**
 * Description: 基础实体类
 */
public class BaseModel {
    private String msg;
    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseModel() {
    }

}

