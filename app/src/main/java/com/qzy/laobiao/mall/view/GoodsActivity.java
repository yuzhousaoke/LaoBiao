package com.qzy.laobiao.mall.view;

import android.view.View;
import android.widget.ImageView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;

import butterknife.BindView;

/*订单页面*/
public class GoodsActivity extends BasePresenterFragActivity {

    @BindView(R.id.goods_back)
    ImageView orderBack;

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_goods;
    }

    @Override
    protected void initView() {
        super.initView();
        //退出当前页面
        orderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
