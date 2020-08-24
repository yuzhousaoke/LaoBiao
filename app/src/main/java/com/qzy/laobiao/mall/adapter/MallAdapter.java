package com.qzy.laobiao.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.mall.model.MallModel;

import java.util.List;

public class MallAdapter extends BaseAdapter {

    protected Context context;
    private List<MallModel> mMallDataList;

    public MallAdapter(List<MallModel> mMallDataList, Context context) {
        this.mMallDataList = mMallDataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mMallDataList == null ? 0 : mMallDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mMallDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.mall_item, null);
            holder = new ViewHolder();
            holder.mall_icon = view.findViewById(R.id.mall_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mall_icon.setImageResource(mMallDataList.get(i).getMall_icon());
        return view;
    }

    class ViewHolder {
        ImageView mall_icon;
    }
}
