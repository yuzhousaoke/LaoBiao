package com.qzy.laobiao.common.manager;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


import com.qzy.laobiao.R;
import com.qzy.laobiao.common.utils.AppUtils;
import com.qzy.laobiao.common.utils.StringUtils;

import java.util.Objects;

/**
 * artifact  标题栏管理类
 */
public class TitleManager {

    private Activity ac;
    private View view;
    private Resources rs;

    public TitleManager(Activity ac) {
        this.ac = ac;
        rs = ac.getResources();
    }

    public TitleManager(View view) {
        this.view = view;
        rs = view.getResources();
    }

    public interface RightLayoutListener {
        void rightOnListener();
    }


    /**
     * 设置标题栏白色背景
     */
    public void setToolBarBg() {
        Toolbar toolbar;
        if (ac != null) {
            toolbar = ac.findViewById(R.id.toolbar);
            toolbar.setBackgroundColor(Color.WHITE);
        }
    }


    public void setLeftLayout(int leftTxtId, int leftImgId) {

        ImageView mLeftImg;
        TextView mLeftTxt;
        LinearLayout layout = null;
        if (ac == null) {
            mLeftImg = view.findViewById(R.id.left_img);
            mLeftTxt = view.findViewById(R.id.left_txt);
        } else {
            layout = ac.findViewById(R.id.left_layout);
            mLeftImg = ac.findViewById(R.id.left_img);
            mLeftTxt = ac.findViewById(R.id.left_txt);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppUtils.hintKbTwo(ac);
                    ac.overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
                    ac.finish();
                }
            });
        }
        if (layout != null) {
            layout.setVisibility(View.VISIBLE);
        }
        if (leftTxtId > 0) {
            mLeftTxt.setText(rs.getString(leftTxtId));
        }
        if (leftImgId > 0) {
            mLeftImg.setBackgroundResource(leftImgId);
        }
    }


    public void setLeftLayout(int leftTxtId, int leftImgId, final View.OnClickListener l) {

        ImageView mLeftImg;
        TextView mLeftTxt;
        LinearLayout layout = null;
        if (ac == null) {
            mLeftImg = view.findViewById(R.id.left_img);
            mLeftTxt = view.findViewById(R.id.left_txt);
        } else {
            layout = ac.findViewById(R.id.left_layout);
            mLeftImg = ac.findViewById(R.id.left_img);
            mLeftTxt = ac.findViewById(R.id.left_txt);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l.onClick(v);
                }
            });
        }
        if (layout != null) {
            layout.setVisibility(View.VISIBLE);
        }
        if (leftTxtId > 0) {
            mLeftTxt.setText(rs.getString(leftTxtId));
        }
        if (leftImgId > 0) {
            mLeftImg.setBackgroundResource(leftImgId);
        }
    }


    /**
     * 设置标题栏标题文本
     *
     * @param rId
     */
    public void setTitleTxt(int rId) {
        TextView mTitleTxt;
        if (ac == null) {
            mTitleTxt = view.findViewById(R.id.title_txt);
        } else {
            mTitleTxt = ac.findViewById(R.id.title_txt);
        }
        mTitleTxt.setText(rs.getString(rId));
    }

    /**
     * 设置标题栏标题文本
     *
     * @param txt
     */
    public void setTitleTxt(String txt) {
        TextView mTitleTxt;
        if (ac == null) {
            mTitleTxt = view.findViewById(R.id.title_txt);
        } else {
            mTitleTxt = ac.findViewById(R.id.title_txt);
        }
        mTitleTxt.setText(txt);
    }

    /**
     * 设置右侧图片文字
     */
    public void setRightLayout(int rightTxtId, int rightImgId, final RightLayoutListener listener) {

        LinearLayout layout;
        TextView rightTxt;
        ImageView rightImg;
        if (ac == null) {
            layout = view.findViewById(R.id.right_layout);
            rightImg = view.findViewById(R.id.right_img);
            rightTxt = view.findViewById(R.id.right_txt);
        } else {
            layout = ac.findViewById(R.id.right_layout);
            rightImg = ac.findViewById(R.id.right_img);
            rightTxt = ac.findViewById(R.id.right_txt);
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });

        if (rightTxtId > 0) {
            rightTxt.setText(rs.getString(rightTxtId));
        }
        if (rightImgId > 0) {
            rightImg.setVisibility(View.VISIBLE);
            rightImg.setBackgroundResource(rightImgId);
        } else {
            rightImg.setVisibility(View.GONE);
        }
    }


    /**
     * 设置右侧图片文字
     */
    public void setRightLayout(String rightStrTxt, int rightImgId, final RightLayoutListener listener) {

        LinearLayout layout;
        TextView rightTxt;
        ImageView rightImg;
        if (ac == null) {
            layout = view.findViewById(R.id.right_layout);
            rightImg = view.findViewById(R.id.right_img);
            rightTxt = view.findViewById(R.id.right_txt);
        } else {
            layout = ac.findViewById(R.id.right_layout);
            rightImg = ac.findViewById(R.id.right_img);
            rightTxt = ac.findViewById(R.id.right_txt);
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });

        if (!StringUtils.isEmpty(rightStrTxt)) {
            rightTxt.setText(rightStrTxt);
        }
        if (rightImgId > 0) {
            rightImg.setVisibility(View.VISIBLE);
            rightImg.setBackgroundResource(rightImgId);
        } else {
            rightImg.setVisibility(View.GONE);
        }
    }


    /**
     * 设置标题栏左边图标
     *
     * @param rId
     */
    public void setLeftImg(int rId) {
        ImageView mLeftImg;
        if (ac == null) {
            mLeftImg = view.findViewById(R.id.left_img);
        } else {
            mLeftImg = ac.findViewById(R.id.left_img);
        }
        mLeftImg.setBackgroundResource(rId);
    }

    /**
     * 设置标题栏左边文本
     *
     * @param rId
     */
    public void setLeftTxt(int rId) {
        TextView mLeftTxt;
        if (ac == null) {
            mLeftTxt = view.findViewById(R.id.left_txt);
        } else {
            mLeftTxt = ac.findViewById(R.id.left_txt);
        }

        mLeftTxt.setText(rs.getString(rId));
    }

    /**
     * 设置标题栏右边图标
     *
     * @param rId
     */
    public void setRightImg(int rId) {
        ImageView mRightImg;
        if (ac == null) {
            mRightImg = view.findViewById(R.id.right_img);
        } else {
            mRightImg = ac.findViewById(R.id.right_img);
        }
        mRightImg.setBackgroundResource(rId);
    }

    /**
     * 设置标题栏右边图标
     *
     * @param rId
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setRightImgOnClick(int rId, int doubleImg, final RightLayoutListener listener, final RightLayoutListener listener1) {
        ImageView mRightImg;
        ImageView mDoubleRightImg;

        if (ac == null) {
            mRightImg = view.findViewById(R.id.right_img);
            mDoubleRightImg = view.findViewById(R.id.right_double_img);
        } else {
            mRightImg = ac.findViewById(R.id.right_img);
            mDoubleRightImg = ac.findViewById(R.id.right_double_img);
        }

        if (mRightImg != null && mDoubleRightImg != null) {
            mRightImg.setVisibility(View.VISIBLE);
            mDoubleRightImg.setVisibility(View.VISIBLE);

            mRightImg.setBackgroundResource(rId);
            mDoubleRightImg.setImageResource(doubleImg);
        }

        Objects.requireNonNull(mRightImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });

        Objects.requireNonNull(mDoubleRightImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener1.rightOnListener();
            }
        });

    }

    /**
     * 设置标题栏右边文本
     *
     * @param rId
     */
    public void setRightTxt(int rId) {
        TextView mRightTxt;
        if (ac == null) {
            mRightTxt = view.findViewById(R.id.right_txt);
        } else {
            mRightTxt = ac.findViewById(R.id.right_txt);
        }
        mRightTxt.setText(rs.getString(rId));
    }


    /**
     * 设置标题栏右边文本
     *
     * @param rId      string
     * @param textSize 字体大小 不是dimens
     * @param drawable drawable
     *                 int left, int top, int right, int bottom
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setRightTxt(int rId, int textSize, int drawable, int leftAndRightPadding, int topAndBottomPadding, View.OnClickListener listener) {
        TextView mRightTxt;
        if (ac == null) {
            mRightTxt = view.findViewById(R.id.right_txt);
        } else {
            mRightTxt = ac.findViewById(R.id.right_txt);
        }
        mRightTxt.setTextColor(Color.BLACK);
        mRightTxt.setTextSize(textSize);
        mRightTxt.setText(rs.getString(rId));
        //mRightTxt.setBackground(rs.getDrawable(drawable));
        if (drawable!=-1) {
            mRightTxt.setBackground(ContextCompat.getDrawable(ac, drawable));
        }
        mRightTxt.setGravity(Gravity.CENTER);
        mRightTxt.setPadding(rs.getDimensionPixelOffset(leftAndRightPadding), rs.getDimensionPixelOffset(topAndBottomPadding), rs.getDimensionPixelOffset(leftAndRightPadding), rs.getDimensionPixelOffset(topAndBottomPadding));
        mRightTxt.setOnClickListener(listener);
    }

    public void setRightTxt(int rId, int textSize, int color, View.OnClickListener listener) {
        TextView mRightTxt;
        if (ac == null) {
            mRightTxt = view.findViewById(R.id.right_txt);
        } else {
            mRightTxt = ac.findViewById(R.id.right_txt);
        }
        mRightTxt.setTextColor(ContextCompat.getColor(ac, color));
        mRightTxt.setTextSize(textSize);
        mRightTxt.setText(rs.getString(rId));
        mRightTxt.setOnClickListener(listener);
    }


    /**
     * 设置标题栏点击右布局响应事件
     *
     * @param listener
     */
    public void setRightLayoutListener(final RightLayoutListener listener) {
        LinearLayout layout;
        if (ac == null) {
            layout = view.findViewById(R.id.right_layout);
        } else {
            layout = ac.findViewById(R.id.right_layout);
        }

        layout.setVisibility(View.VISIBLE);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });
    }

}