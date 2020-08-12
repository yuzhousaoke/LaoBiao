package com.qzy.laobiao.common.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * artifact  自定义ListBaseAdapter
 */
public class ListBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    private List<T> dates;


    public void setDates(List<T> beans) {
        dates = beans;
        notifyDataSetChanged();
    }

    public void addForeDatas(List<T> beans) {
        if (dates == null) {
            setDates(beans);
        } else {
            dates.addAll(0, beans);
        }
        notifyDataSetChanged();
    }

    public void addDatas(List<T> beans) {
        if (dates == null) {
            setDates(beans);
        } else {
            dates.addAll(beans);
        }
        notifyDataSetChanged();
    }

    public List<T> getDates() {
        return dates;
    }

    protected ListBaseAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return null == dates ? 0 : dates.size();
    }

    @Override
    public T getItem(int position) {
        return null == dates ? null : dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
