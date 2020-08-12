package com.qzy.laobiao.common.base;

import androidx.fragment.app.Fragment;

/**
 * artifact  懒加载
 * */
public abstract class LazyFragment extends Fragment {

	protected boolean isVisible;
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(getUserVisibleHint()) {
			isVisible = true;
			onVisible();
		} else {
			isVisible = false;
			onInvisible();
		}
	}
	private void onVisible(){
		lazyLoad();
	}
	protected abstract void lazyLoad();
	private void onInvisible(){}
}
