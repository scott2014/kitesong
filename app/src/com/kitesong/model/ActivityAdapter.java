package com.kitesong.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ActivityAdapter extends BaseAdapter {
	
	private Context mContext = null;
	
	public ActivityAdapter(Context context) {
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup viewGroup) {
		
		if (convertView == null) {
			
		}
		
		return null;
	}

}
