package com.qzy.laobiao.msg.view;


import android.view.View;
import android.widget.ListView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterActivity;
import com.qzy.laobiao.msg.adapter.HdXiaoxiAdapter;
import com.qzy.laobiao.msg.model.HdXiaoxiModel;

import java.util.ArrayList;
import java.util.List;

public class InteractiveActivity extends BasePresenterActivity {

    private ListView hd_xiaoxi_lvl;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_interactive;
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
        hd_xiaoxi_lvl = findViewById(R.id.hd_xiaoxi_lv);
        List<HdXiaoxiModel> mStudentDataList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            HdXiaoxiModel mStudentData = new HdXiaoxiModel();      //循环创建studentData 对象
            mStudentData.setName("小宇哥");          //为对象设置姓名
            mStudentData.setInstructions("来斗地主吧");                             //为对象设置 年龄
            mStudentData.setHuifu_time("回复了你的评论  2019-06-11");
            mStudentData.setImg(R.drawable.wxbg);
            mStudentData.setIcon(R.drawable.wxbg);              //为对象设置照片
            mStudentDataList.add(mStudentData);                  //将对象添加到列表中
            HdXiaoxiAdapter hdXiaoxiAdapter = new HdXiaoxiAdapter(mStudentDataList, InteractiveActivity.this);
            hd_xiaoxi_lvl.setAdapter(hdXiaoxiAdapter);
        }
    }


}
