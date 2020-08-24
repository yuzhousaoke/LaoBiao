package com.qzy.laobiao.home.view;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.mall.adapter.MallAdapter;
import com.qzy.laobiao.mall.model.MallModel;
import com.qzy.laobiao.msg.adapter.XiaoxiAdapter;
import com.qzy.laobiao.msg.model.XiaoxiLvModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends BasePresenterFragment {
    @BindView(R.id.mall_lv)
    ListView mall_lv;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mall;
    }

    @Override
    protected void initView() {
        super.initView();

        List<MallModel> mMallDataList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            MallModel mMallData = new MallModel();
            mMallData.setMall_icon(R.drawable.mall_icon);

            mMallDataList.add(mMallData);
            MallAdapter mallAdapter = new MallAdapter(mMallDataList, getContext());
            mall_lv.setAdapter(mallAdapter);
            mall_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    UIManager.switcher(getContext(), MallActivity.class);
                }
            });
        }

//        List<XiaoxiLvModel> mStudentDataList = new ArrayList<>();
//        for (int i = 1; i <= 3; i++) {
//            XiaoxiLvModel mStudentData = new XiaoxiLvModel();      //循环创建studentData 对象
//            mStudentData.setName("罗永浩的门店");          //为对象设置姓名
//            mStudentData.setInstructions("柳州市柳南区声福国际18栋4室");                             //为对象设置 年龄
//            mStudentData.setIcon(R.drawable.wxbg);              //为对象设置照片
//            mStudentDataList.add(mStudentData);                  //将对象添加到列表中
//            XiaoxiAdapter xiaoxiAdapter = new XiaoxiAdapter(mStudentDataList,getContext());
//            mall_lv.setAdapter(xiaoxiAdapter);
//            mall_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    UIManager.switcher(getContext(), MallActivity.class);
//                }
//            });
//        }
    }
}
