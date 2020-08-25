package com.qzy.laobiao.mall.model;

public class MallGoodsModel {
    private String goods_icon;//商品图片网址
    private String goods_price;//商品价格
    private String goods_salesvolume;//商品销量

    public String getGoods_icon() {
        return goods_icon;
    }

    public void setGoods_icon(String goods_icon) {
        this.goods_icon = goods_icon;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_salesvolume() {
        return goods_salesvolume;
    }

    public void setGoods_salesvolume(String goods_salesvolume) {
        this.goods_salesvolume = goods_salesvolume;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    private String goods_name;//商品名称
}
