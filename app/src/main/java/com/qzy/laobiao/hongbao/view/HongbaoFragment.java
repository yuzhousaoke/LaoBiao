package com.qzy.laobiao.hongbao.view;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.qzy.laobiao.R;
import com.qzy.laobiao.common.base.BasePresenterFragment;
import com.qzy.laobiao.common.manager.UIManager;
import com.qzy.laobiao.login.view.LoginActivity;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HongbaoFragment extends BasePresenterFragment {
    @BindView(R.id.renwu)
    Button renwu;

    public HongbaoFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_hongbao;
    }

    @Override
    protected void initView() {
        super.initView();
        renwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.switcher(getContext(), LoginActivity.class);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
