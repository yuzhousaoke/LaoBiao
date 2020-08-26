package com.qzy.laobiao.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentTabAdapter extends FragmentPagerAdapter {

    private List<SinglePage> mGuideContent;
    private Context mCtx;

    public FragmentTabAdapter(FragmentActivity a, List<SinglePage> guideContent) {
        super(a.getSupportFragmentManager());
        mCtx = a;
        mGuideContent = guideContent;
    }

    @Override
    public Fragment getItem(int position) {
        // Get a local reference
        SinglePage sp = mGuideContent.get(position);
        if (sp.mCustomFragment != null) {
            // This single page has custom fragment, use it
            return sp.mCustomFragment;
        } else {
            PageFragment pageFragment = (PageFragment) Fragment.instantiate(mCtx, PageFragment.class.getName());
            if (sp.mBackground != null) {
                pageFragment.setBg(sp.mBackground);
            }
            return pageFragment;
        }
    }

    @Override
    public int getCount() {
        return mGuideContent.size();
    }

    public static final class PageFragment extends Fragment {
        private Drawable mBg;
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ImageView iv = new ImageView(getActivity());
            if (mBg != null) {
                iv.setBackground(mBg);
            }
            return iv;
        }
        public void setBg(Drawable mBackground) {
            mBg = mBackground;
        }
    }
}
