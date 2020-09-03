package com.qzy.laobiao.mall.view;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenter;
import com.qzy.laobiao.common.base.BasePresenterFragActivity;
import com.qzy.laobiao.common.manager.BannerGlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import butterknife.BindView;

/* 商品详情页面 */
public class GoodsActivity extends BasePresenterFragActivity {

    @BindView(R.id.goods_back)
    ImageView orderBack;
    @BindView(R.id.goods_banner)
    Banner banner;

    private ArrayList<String> banner_list = new ArrayList<String>();

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
//        退出当前页面
        orderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        banner_list.add("https://img.zcool.cn/community/014ffd5a62dbcea80120121f1f10b3.jpg");
        banner_list.add("https://img.zcool.cn/community/012a875a62dbcfa80120121fdf9a08.jpg");
        banner_list.add("https://img.zcool.cn/community/01d0135a62dbcda8012113c7abae58.jpg");
        banner_list.add("https://img.zcool.cn/community/01f0aa5a62dbd1a8012113c7c91cf1.jpg");
        banner_list.add("https://img.zcool.cn/community/01d0495a62dbcea80120121f33919f.jpg");
        banner_list.add("https://img.zcool.cn/community/01cf4d5a62dbc9a8012113c795023b.jpg");
        banner.setBannerStyle(BannerConfig.RIGHT);
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        ViewGroup.LayoutParams params = banner.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.widthPixels;//商品的轮播图，以正方形显示
        banner.setLayoutParams(params);
        banner.setImageLoader(new BannerGlideImageLoader()).setImages(banner_list).start();
        banner.stopAutoPlay();
//        ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.colorPrimary).init();
    }
}
