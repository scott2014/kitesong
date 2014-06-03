package com.kitesong.fragment;

import java.util.ArrayList;
import java.util.List;

import org.holoeverywhere.app.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.kitesong.R;
import com.kitesong.model.UserPagerAdapter;

public class UserFragment extends Fragment {
	
	private ImageView mCursor = null;
	
	private Context mContext = null;
	
	//游标偏移量
	private int mOffSetX = 0;
	//游标宽度
	private int mCursorW = 0;
	//当前所在游标索引
	private int currIndex = 0;
	//视图分页类 
	private ViewPager mViewPager = null;
	
	private Resources mRs = null;
	
	
	@Override
    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user);
        
        View v1 = inflater.inflate(R.layout.user_item_profile);
        View v2 = inflater.inflate(R.layout.user_item_fancy);
        View v3 = inflater.inflate(R.layout.user_item_lists);
        
        v1.setOnClickListener(new TabClickListener(0));
        v2.setOnClickListener(new TabClickListener(1));
        v3.setOnClickListener(new TabClickListener(2));


        
        List<View> viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        
        List<String> titleList = new ArrayList<String>();
        
        Resources res = inflater.getContext().getResources();
        titleList.add(res.getString(R.string.profile));
        titleList.add(res.getString(R.string.fancy));
        titleList.add(res.getString(R.string.lists));
        
        
        UserPagerAdapter pagerAdapter = new UserPagerAdapter(viewList, titleList);
        
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(pagerAdapter);
        
        this.mCursor = (ImageView) view.findViewById(R.id.cursor);
        
        this.mContext = view.getContext();
        
        InitCursor();
        
        this.mViewPager.setOnPageChangeListener(new TabPageChangeListener());
        
       /* TextView tv1 = (TextView)inflater.inflate(R.id.profile_textView);
        TextView tv2 = (TextView)inflater.inflate(R.id.fancy_textView);
        TextView tv3 = (TextView)inflater.inflate(R.id.lists_textView);
        
        tv1.setOnClickListener(new TabClickListener(0));
        tv2.setOnClickListener(new TabClickListener(1));
        tv3.setOnClickListener(new TabClickListener(2));*/
        
        this.mRs = getResources();
        
        return view;
	}
	
	private void InitCursor() {
		this.mCursorW = BitmapFactory.decodeResource(getResources(), R.drawable.cursor).getWidth();
		
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm = (WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE);
		
		Display display = wm.getDefaultDisplay();
		display.getMetrics(dm);
		
		int screenW = dm.widthPixels;
		this.mOffSetX = (screenW / 3 - mCursorW) / 2;
		
		Matrix matrix = new Matrix();
		matrix.postTranslate(this.mOffSetX, 0);
		this.mCursor.setImageMatrix(matrix);
	}
	
	
	
	//标签页切换点击监听器
	private class TabClickListener implements OnClickListener {
		private int index = 0;
		
		public TabClickListener(int index) {
			this.index = index;
		}
		
		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(index);
		}
		
	}
	
	//页面切换监听器，使游标随着切换移动
	private class TabPageChangeListener implements OnPageChangeListener {
		int one = mOffSetX * 3 + mCursorW;
		int two = one * 2 - mOffSetX;
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onPageSelected(int index) {
			Animation animation = new TranslateAnimation(one*currIndex, one*index,0,0);
			currIndex = index;
			animation.setFillAfter(true);
			animation.setDuration(300);
			mCursor.startAnimation(animation);
		}
		
		
	}
	
	
	 public void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			this.getSupportActionBar().setTitle(mRs.getString(R.string.activity));
		}
}
