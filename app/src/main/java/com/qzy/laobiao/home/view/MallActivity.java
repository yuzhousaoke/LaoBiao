package com.qzy.laobiao.home.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;
import com.qzy.laobiao.mall.adapter.MallGoodsAdapter;
import com.qzy.laobiao.mall.model.MallGoodsModel;
import com.qzy.laobiao.mall.view.GoodsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*门店页面*/
public class MallActivity extends BasePresenterFragActivity {

    @BindView(R.id.mall_refreshlayout)
    SwipeRefreshLayout mall_srl;
    @BindView(R.id.mall_goods_gv)
    GridView goods_gv;
    @BindView(R.id.goods_back)
    ImageView goodsBack;

    private int i = 1;
    private List<MallGoodsModel> mGoodsDataList = new ArrayList<>();
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

        mall_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                mall_srl.setRefreshing(true);
                for (int i = 1; i < 30; i++) {
                    MallGoodsModel mallData = new MallGoodsModel();
                    mGoodsDataList.add(mallData);
                    MallGoodsAdapter mallGoodsAdapter = new MallGoodsAdapter(mGoodsDataList, getApplication());
                    goods_gv.setAdapter(mallGoodsAdapter);
                    goods_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(MallActivity.this, GoodsActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                mall_srl.setRefreshing(false);
            }
        });

//        mall_srl.setRefreshing(true);
    }

}
