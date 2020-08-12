package com.qzy.laobiao.mine.view;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;
import com.qzy.laobiao.login.model.UserInfoModel;
import com.qzy.laobiao.mine.adapter.TabPagerAdapter;
import com.qzy.laobiao.mine.impl.MineView;
import com.qzy.laobiao.mine.presenter.MinePresenter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BasePresenterFragment<MinePresenter> implements MineView {

    @BindView(R.id.mine_tab)
    TabLayout tabLayout;
    @BindView(R.id.mine_vp)
    ViewPager vp;
    @BindView(R.id.mine_name)
    TextView mine_name;
    @BindView(R.id.mine_userid)
    TextView mine_userid;
//    @BindView(R.id.mine_scroll)
//    ScaleScrollView mine_scroll;
    @BindView(R.id.banner)
    RelativeLayout banne;

    //滑动页中所添加碎片的集合
    private List<Fragment> fragments;
    //tab栏标题的集合
    private List<String> titleList;
    //Tab栏和滑动页关联适配器
    private TabPagerAdapter adapter;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter(context);
    }

    @Override
    protected void initView() {
        super.initView();
//        mine_scroll.setTargetView(banne);
        mPresenter.setMineView(this);
        fragments = new ArrayList<>();
        titleList = new ArrayList<>();

        titleList.clear();
        titleList.add("作品 0");
        titleList.add("喜欢 0");

        //添加fragment
        fragments.add(MyVideoFragment.newInstance(-1));
        fragments.add(MyVideoFragment.newInstance(0));

        //将tab栏和滑动页关联起来
        adapter = new TabPagerAdapter(getFragmentManager(), fragments, titleList);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(1);

        //设置tablayout和viewpager可联动
        tabLayout.setupWithViewPager(vp);
        //设置tablayout可以滑动 宽度自适应屏幕大小
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        mPresenter.getMineInfo(context);
    }

    @Override
    public void onGetMineInfo(UserInfoModel model) {
        mine_name.setText(model.getBody().getAccount().getNickName());
        mine_userid.setText("id  " + model.getBody().getAccount().getId());
    }
}
