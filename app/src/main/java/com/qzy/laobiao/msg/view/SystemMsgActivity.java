package com.qzy.laobiao.msg.view;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterActivity;
import com.qzy.laobiao.msg.adapter.XtXiaoAdapter;
import com.qzy.laobiao.msg.model.XtXiaoxiModel;

import java.util.ArrayList;
import java.util.List;

public class SystemMsgActivity extends BasePresenterActivity {
    private ListView xt_xiaoxi_lv;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_system_msg;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.fl_setting_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xt_xiaoxi_lv = findViewById(R.id.xt_xiaoxi_lv);
        List<XtXiaoxiModel> mStudentDataList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            XtXiaoxiModel mStudentData = new XtXiaoxiModel();      //循环创建studentData 对象
            mStudentData.setName("系统消息");          //为对象设置姓名
            mStudentData.setInstructions("你好，欢迎来到老表短视频");                             //为对象设置 年龄
            mStudentData.setHuifu_time("2020-03-06 00：13");
            mStudentData.setIcon(R.drawable.wxbg);              //为对象设置照片
            mStudentDataList.add(mStudentData);                  //将对象添加到列表中
            XtXiaoAdapter xtXiaoxiModel = new XtXiaoAdapter(mStudentDataList, SystemMsgActivity.this);
            xt_xiaoxi_lv.setAdapter(xtXiaoxiModel);
        }
    }
}
