package com.qzy.laobiao.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qzy.laobiao.MainActivity;
import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.common.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/*首次运行页面*/
public class SplashActivity extends AbsGuideActivity {
    @Override
    public List<SinglePage> buildGuideContent() {

        if (!BaseApplication.getInstance().isLogin()) {//没有登录过，显示闪屏页
            List<SinglePage> guideContent = new ArrayList<SinglePage>();
            SinglePage page01 = new SinglePage();
            page01.mBackground = getResources().getDrawable(R.drawable.sp1);
            guideContent.add(page01);

            SinglePage page02 = new SinglePage();
            page02.mBackground = getResources().getDrawable(R.drawable.sp2);
            guideContent.add(page02);

            SinglePage page03 = new SinglePage();
            page03.mBackground = getResources().getDrawable(R.drawable.sp3);
            guideContent.add(page03);

            SinglePage page05 = new SinglePage();
            page05.mCustomFragment = new EntryFragment();
            guideContent.add(page05);

            return guideContent;

        } else {//登录过了，跳到主页
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return null;
        }
    }

    @Override
    public boolean drawDot() {
        return true;
    }

    @Override
    public Bitmap dotDefault() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_dot_default);
    }

    @Override
    public Bitmap dotSelected() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_dot_selected);
    }

    /**
     * You need provide an id to the pager. You could define an id in values/ids.xml and use it.
     */
    @Override
    public int getPagerId() {
        return R.id.guide_container;
    }
}
