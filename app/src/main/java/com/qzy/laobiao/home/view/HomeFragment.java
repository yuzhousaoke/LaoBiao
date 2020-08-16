package com.qzy.laobiao.home.view;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;
import com.qzy.laobiao.mine.adapter.TabPagerAdapter;
import com.qzy.laobiao.videoCom.LocalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BasePresenterFragment {
    @BindView(R.id.home_tab)
    XTabLayout home_tab;
    @BindView(R.id.home_vp)
    ViewPager home_vp;

    //滑动页中所添加碎片的集合
    private List<Fragment> fragments;

    //tab栏标题的集合
    private List<String> titleList;
    //Tab栏和滑动页关联适配器
    private TabPagerAdapter adapter;
    private LocalFragment localFragment;
    private FriendsVideoFragment friendsVideoFragment;
    private MallFragment mallShopsFragment;
    private int mPosition = 0;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();
        ImmersionBar.with(this).init();
        titleList = new ArrayList<>();
        fragments = new ArrayList<>();

        titleList.clear();
        titleList.add("柳州");
        titleList.add("好友");
        titleList.add("门店");

        localFragment = new LocalFragment();
        friendsVideoFragment = new FriendsVideoFragment();
        mallShopsFragment = new MallFragment();

        //添加fragment
        fragments.add(localFragment);
        fragments.add(friendsVideoFragment);
        fragments.add(mallShopsFragment);

        //将tab栏和滑动页关联起来
        adapter = new TabPagerAdapter(getChildFragmentManager(), fragments, titleList);
        home_vp.setAdapter(adapter);
        home_vp.setOffscreenPageLimit(2);
        home_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mPosition = position;
                if(position == 0){
                    localFragment.show();
                    friendsVideoFragment.hide();
                }else if(position == 1){
                    friendsVideoFragment.show();
                    localFragment.hide();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置tablayout和viewpager可联动
        home_tab.setupWithViewPager(home_vp);
        localFragment.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPosition == 0) {
            if (localFragment != null) {
                localFragment.show();
            }
            if (friendsVideoFragment != null) {
                friendsVideoFragment.hide();
            }
        } else if (mPosition == 1) {
            if (localFragment != null) {
                localFragment.hide();
            }
            if (friendsVideoFragment != null) {
                friendsVideoFragment.show();
            }
        }
    }

        @Override
    public void onPause() {
        super.onPause();
        localFragment.hide();
        friendsVideoFragment.hide();
    }
}
