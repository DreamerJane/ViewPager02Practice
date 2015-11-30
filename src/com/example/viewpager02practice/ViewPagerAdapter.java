package com.example.viewpager02practice;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter {

	private List<View> list;
	
	public ViewPagerAdapter(List<View> list) {
		this.list = list;
	}
	@Override
	public int getCount() {
		if(list != null) {
			return list.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	@Override
	public void destroyItem(View view, int position, Object object) {
		((ViewPager) view).removeView(list.get(position));
	}
	@Override
	public Object instantiateItem(View view, int position) {
		((ViewPager) view).addView(list.get(position));
		return list.get(position);
	}

}
