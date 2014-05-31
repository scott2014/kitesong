package com.kitesong.model;

import org.holoeverywhere.LayoutInflater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kitesong.R;

public class MainAdapter extends BaseAdapter {
	
	private Context mContext = null;
	
	public MainAdapter(Context context) {
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup viewGroup) {
		
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			
			convertView = inflater.inflate(R.layout.common_list_item);
		}
		return convertView;
	}

}
