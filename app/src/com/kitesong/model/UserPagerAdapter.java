package com.kitesong.model;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class UserPagerAdapter extends PagerAdapter {
	
	private List<View> mViewList = null;
	private List<String> mTitleList = null;
	
	public UserPagerAdapter(List<View> viewList,List<String> titleList) {
		this.mViewList = viewList;
		this.mTitleList = titleList;
	}
	
	@Override
	public int getCount() {
		return this.mViewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(this.mViewList.get(position));
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return this.mTitleList.get(position);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mViewList.get(position));
		return mViewList.get(position);
	}
}
