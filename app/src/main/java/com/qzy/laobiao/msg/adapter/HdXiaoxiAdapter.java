package com.qzy.laobiao.msg.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.msg.model.HdXiaoxiModel;

import java.util.List;

public class HdXiaoxiAdapter extends BaseAdapter {
    protected Context context;
    private List<HdXiaoxiModel> mStudentDataList;   //创建一个StudentData 类的对象 集合

    public HdXiaoxiAdapter(List<HdXiaoxiModel> mStudentDataList, Context context) {
        this.mStudentDataList = mStudentDataList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return mStudentDataList == null ? 0 : mStudentDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStudentDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hdxiaoxi_item, null);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
            holder.xiaoxi_img = convertView.findViewById(R.id.xiaoxi_img);
            holder.name = convertView.findViewById(R.id.name);
            holder.instructions = convertView.findViewById(R.id.instructions);
            holder.huifu_time = convertView.findViewById(R.id.huifu_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(mStudentDataList.get(position).getName());
        holder.instructions.setText(mStudentDataList.get(position).getInstructions());
        holder.huifu_time.setText(mStudentDataList.get(position).getHuifu_time());
        holder.icon.setImageResource(mStudentDataList.get(position).getIcon());
        holder.xiaoxi_img.setImageResource(mStudentDataList.get(position).getIcon());
        return convertView;
    }

    class ViewHolder {
        TextView name, instructions,huifu_time;
        ImageView icon,xiaoxi_img;
    }


}

