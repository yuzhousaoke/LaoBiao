package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import static androidx.annotation.RestrictTo.Scope.LIBRARY;
import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;
import static androidx.annotation.RestrictTo.Scope.SUBCLASSES;


public class FooterLoadLayout extends LinearLayout implements RefreshFooter {

    private ImageView loading_img;
    private TextView refresh_tv;

    AnimationDrawable animationDrawable;


    protected boolean mNoMoreData = false;


    public FooterLoadLayout(Context context) {
        super(context);
        initView(context);
    }

    public FooterLoadLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context);
    }

    public FooterLoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context);
    }

    private void initView(Context context) {
        setGravity(Gravity.CENTER);
        View rootView = View.inflate(getContext(), R.layout.view_load_head, null);
        loading_img = (ImageView) rootView.findViewById(R.id.loading_img);
        refresh_tv = (TextView) rootView.findViewById(R.id.refresh_tv);

        loading_img.setBackgroundResource(R.drawable.anim_loading_view);
        animationDrawable = (AnimationDrawable) loading_img.getBackground();

        addView(rootView);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        if (animationDrawable != null) {
            animationDrawable.start();//开始动画
        }
    }


    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (animationDrawable != null) {
            animationDrawable.stop();//停止动画
        }
        if (!mNoMoreData) {
            refresh_tv.setText(success ? "刷新完成" : "刷新失败");
        }
        return 500;//延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        if (!mNoMoreData) {
            switch (newState) {
                case None:
                case PullDownToRefresh:
                    refresh_tv.setText("加载更多");
                    break;
                case Refreshing:
                    refresh_tv.setText("正在加载");
                    break;
                case ReleaseToRefresh:
                    refresh_tv.setText("释放刷新");
                    break;
            }
        }
    }

    @RestrictTo({LIBRARY, LIBRARY_GROUP, SUBCLASSES})
    @Override
    public boolean setNoMoreData(boolean noMoreData) {
        if (mNoMoreData != noMoreData) {
            mNoMoreData = noMoreData;

            if (noMoreData) {
                refresh_tv.setText("没有更多数据");
                loading_img.setVisibility(GONE);
            } else {
                refresh_tv.setText("加载更多");
                loading_img.setVisibility(VISIBLE);
            }
        }
        return true;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }


    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

}
