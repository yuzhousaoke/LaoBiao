package com.qzy.laobiao.home.view;


import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


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
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends BasePresenterFragment {
    @BindView(R.id.mall_lv)
    ListView mall_lv;
    @BindView(R.id.mall_laichi)
    TextView laichi;
    @BindView(R.id.mall_laiyong)
    TextView laiyong;
    @BindView(R.id.mall_laiwan)
    TextView laiwan;
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
    }

    @OnClick(R.id.mall_laichi)//来吃
    public void doLC(View view) {//点击切换刷新来吃店铺列表
        laichi.setTextColor(Color.parseColor("#F26161"));
        laichi.setBackgroundResource(R.drawable.bg_btn_pink);
        laiyong.setTextColor(Color.parseColor("#444444"));
        laiyong.setBackgroundResource(R.drawable.bg_btn_white);
        laiwan.setTextColor(Color.parseColor("#444444"));
        laiwan.setBackgroundResource(R.drawable.bg_btn_white);

//        rvMovieList.setVisibility(View.GONE);//隐藏一次？也能实现连续刷新
//        page = 1;//清空一次当前页数，并设为1，因为至少为1页
//        page_amount = 0;//清空一次总页数
//        oldListSize = 0;//清空一次列表
//        newListSize = 0;//清空一次列表
//        addListSize = 0;//清空一次列表
//        way = "0";//查询总 设置为0
    }

    @OnClick(R.id.mall_laiyong)//来用
    public void doLY(View view) {//点击切换刷新来用店铺列表
        laichi.setTextColor(Color.parseColor("#444444"));
        laichi.setBackgroundResource(R.drawable.bg_btn_white);
        laiyong.setTextColor(Color.parseColor("#F26161"));
        laiyong.setBackgroundResource(R.drawable.bg_btn_pink);
        laiwan.setTextColor(Color.parseColor("#444444"));
        laiwan.setBackgroundResource(R.drawable.bg_btn_white);

//        rvMovieList.setVisibility(View.GONE);//隐藏一次？也能实现连续刷新
//        page = 1;//清空一次当前页数，并设为1，因为至少为1页
//        page_amount = 0;//清空一次总页数
//        oldListSize = 0;//清空一次列表
//        newListSize = 0;//清空一次列表
//        addListSize = 0;//清空一次列表
//        way = "1";//查询支付宝设置为1
    }

    @OnClick(R.id.mall_laiwan)//来玩
    public void doLW(View view) {//点击切换刷新来玩店铺列表
        laichi.setTextColor(Color.parseColor("#444444"));
        laichi.setBackgroundResource(R.drawable.bg_btn_white);
        laiyong.setTextColor(Color.parseColor("#444444"));
        laiyong.setBackgroundResource(R.drawable.bg_btn_white);
        laiwan.setTextColor(Color.parseColor("#F26161"));
        laiwan.setBackgroundResource(R.drawable.bg_btn_pink);

//        rvMovieList.setVisibility(View.GONE);//隐藏一次？？也能实现连续刷新
//        page = 1;//清空一次页数，并设为1，因为至少为1页
//        page_amount = 0;//清空一次总页数
//        oldListSize = 0;//清空一次列表
//        newListSize = 0;//清空一次列表
//        addListSize = 0;//清空一次列表
//        way = "2";//查询微信设置为2
    }
}
