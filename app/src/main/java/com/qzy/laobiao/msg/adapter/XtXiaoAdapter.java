package com.qzy.laobiao.msg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.msg.model.XtXiaoxiModel;

import java.util.List;

public class XtXiaoAdapter extends BaseAdapter {
    protected Context context;
    private List<XtXiaoxiModel> mStudentDataList;   //创建一个StudentData 类的对象 集合

    public XtXiaoAdapter(List<XtXiaoxiModel> mStudentDataList, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.xtxiaoxi_item, null);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
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
        return convertView;
    }

    class ViewHolder {
        TextView name, instructions, huifu_time;
        ImageView icon;
    }


}

