package com.kitesong.model;

import org.holoeverywhere.LayoutInflater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kitesong.R;

public class ShopAdapter extends BaseAdapter {
	
	private Context mContext = null;
	
	public ShopAdapter(Context context) {
		this.mContext = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
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
		LayoutInflater inflater = LayoutInflater.from(mContext);
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.common_list_item);
		}
		return convertView;
	}

}
