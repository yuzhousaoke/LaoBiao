package com.qzy.laobiao.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.qzy.laobiao.R;
import com.qzy.laobiao.mall.model.MallGoodsModel;

import java.util.List;

public class MallGoodsAdapter extends BaseAdapter {

    protected Context context;
    private List<MallGoodsModel> mGoodsDataList;

    public MallGoodsAdapter(List<MallGoodsModel> mGoodsDataList, Context context) {
        this.mGoodsDataList = mGoodsDataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mGoodsDataList == null ? 0 : mGoodsDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGoodsDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mall_goods_item, null);
            holder = new ViewHolder();
            holder.goods_icon = convertView.findViewById(R.id.goods_icon);
//            RequestOptions options = new RequestOptions().placeholder(R.drawable.goods_shili).error(R.drawable.goods_shili);
//            Glide.with(context).load("").apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.goods_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.goods_icon.setImageResource(mGoodsDataList.get(position).getGoods_icon());
        return convertView;
    }

    class ViewHolder {
        ImageView goods_icon;
    }
}
