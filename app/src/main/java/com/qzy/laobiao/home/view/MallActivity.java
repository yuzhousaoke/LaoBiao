package com.qzy.laobiao.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BaseActivity;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.mall.adapter.MallGoodsAdapter;
import com.qzy.laobiao.mall.model.MallGoodsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MallActivity extends BasePresenterFragActivity {

    @BindView(R.id.mall_goods_gv)
    GridView goods_gv;
    @BindView(R.id.goods_back)
    ImageView goodsBack;

//    @Override //
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mall);
//    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_mall;
    }

    @Override
    protected void initView() {
        super.initView();
        //退出当前页面
        goodsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<MallGoodsModel> mGoodsDataList = new ArrayList<>();
        for(int i = 1; i<30;i++){
            MallGoodsModel mallData = new MallGoodsModel();
            mGoodsDataList.add(mallData);
            MallGoodsAdapter mallGoodsAdapter = new MallGoodsAdapter(mGoodsDataList,this);
            goods_gv.setAdapter(mallGoodsAdapter);
            goods_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MallActivity.this, ConfirmOrderActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
