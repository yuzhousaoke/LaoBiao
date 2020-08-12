package com.qzy.laobiao.common.base;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * artifact  自定义BaseAdapter FOR RecyclerView
 */
public class RecyclerListBaseAdapter<T> extends RecyclerView.Adapter {
    protected Context context;

    protected RecyclerListBaseAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<T> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    protected T getItem(int position) {
        if (null != mDataList && mDataList.size() > 0) {
            return mDataList.get(position);
        } else {
            return null;
        }
    }

    protected List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(Collection<T> list) {
        this.mDataList.clear();
        if (null != list) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> list) {
        int lastIndex = this.mDataList.size();
        if (null != list && this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        if (this.mDataList.size() > 0) {
            mDataList.remove(position);
            notifyItemRemoved(position);
        }

    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }
}
