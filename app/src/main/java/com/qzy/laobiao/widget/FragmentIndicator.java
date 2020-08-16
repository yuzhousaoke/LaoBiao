package com.qzy.laobiao.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qzy.laobiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentIndicator extends LinearLayout {

    @BindView(R.id.bottomLy1)
    FrameLayout ly1;
    @BindView(R.id.bottomText1)
    TextView textView1;

    @BindView(R.id.bottomLy2)
    FrameLayout ly2;
    @BindView(R.id.bottomText2)
    TextView textView2;

    @BindView(R.id.bottomLy3)
    FrameLayout ly3;
    @BindView(R.id.bottomText3)
    TextView textView3;

    @BindView(R.id.bottomLy4)
    FrameLayout ly4;
    @BindView(R.id.bottomText4)
    TextView textView4;
    @BindView(R.id.iv_recorder)
    ImageView iv_recorder;

    /**
     * 跳转编辑、录制选择弹窗
     */
    private MenuDialog mMenuDialog;


    private int mDefaultIndicator = 0;
    private Context context;
    private static int mCurIndicator; // 上一活动指标

    private OnIndicateListener mOnIndicateListener;

    private FragmentIndicatorInterface indicatorInterface;

    private FragmentIndicator(Context context) {
        super(context);
        this.context = context;
    }

    public FragmentIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bottom_tab_view, this, true);
        if (isInEditMode()) return;
        ButterKnife.bind(this);
        mCurIndicator = mDefaultIndicator;

    }

    public interface FragmentIndicatorInterface {
        boolean hasLogin();

        void goLogin(int tag);
    }

    public void setFragmentIndicatorInterface(
            FragmentIndicatorInterface indicatorInterface) {
        this.indicatorInterface = indicatorInterface;
    }

    // 焦点切换时 替换tab图标
    public void setIndicator(int which) {
        switch (mCurIndicator) {
            case 0:
                textView1.setVisibility(View.GONE);
                break;
            case 1:
                textView2.setVisibility(View.GONE);
                break;
            case 2:
                textView3.setVisibility(View.GONE);;
                break;
            case 3:
                textView4.setVisibility(View.GONE);
                break;
        }

        switch (which) {
            case 0:
                textView1.setVisibility(View.VISIBLE);
                break;
            case 1:
                textView2.setVisibility(View.VISIBLE);
                break;
            case 2:
                textView3.setVisibility(View.VISIBLE);
                break;
            case 3:
                textView4.setVisibility(View.VISIBLE);
                break;
        }
        mCurIndicator = which;
    }

    public interface OnIndicateListener {
        void onIndicate(View v, int which);
    }

    public void setOnIndicateListener(OnIndicateListener listener) {
        mOnIndicateListener = listener;
    }

    @OnClick({R.id.bottomLy1, R.id.bottomLy2, R.id.bottomLy3, R.id.bottomLy4,R.id.iv_recorder})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottomLy1:
                if (mCurIndicator != 0) {
                    mOnIndicateListener.onIndicate(view, 0);
                    setIndicator(0);
                }
                break;
            case R.id.bottomLy2:
                if (mCurIndicator != 1) {
                    if (!indicatorInterface.hasLogin()) {
                        indicatorInterface.goLogin(1); //未登录跳转登录
                    }else {
                        mOnIndicateListener.onIndicate(view, 1);
                        setIndicator(1);
                    }
                }
                break;
            case R.id.bottomLy3:
                if (mCurIndicator != 2) {
                    if (!indicatorInterface.hasLogin()) {
                        indicatorInterface.goLogin(2); //未登录跳转登录
                    }else {
                        mOnIndicateListener.onIndicate(view, 2);
                        setIndicator(2);
                    }
                }
                break;
            case R.id.bottomLy4:
                if (mCurIndicator != 3) {
                    if (!indicatorInterface.hasLogin()) {
                        indicatorInterface.goLogin(3); //未登录跳转登录
                    } else {
                        mOnIndicateListener.onIndicate(view, 3);
                        setIndicator(3);
                    }
                }
                break;
            case R.id.iv_recorder:
//                if (mMenuDialog == null) {
//                    initMenuDialog();
//                }
//                mMenuDialog.show();
                mOnIndicateListener.onIndicate(view, 4);
                setIndicator(4);
                break;
        }
    }

    /**
     * 选择fragment
     */
    public void clickBottomLy(int flag) {
        switch (flag) {
            case 0:
                ly1.performClick();
                break;
            case 1:
                ly2.performClick();
                break;
            case 2:
                ly3.performClick();
                break;
            case 3:
                ly4.performClick();
                break;
        }
    }


}

