package com.kitesong.fragment;

import org.holoeverywhere.app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.kitesong.R;

public class GiftsFragment  extends Fragment {
	
	private Resources mRs = null;
	
	 @Override
    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		 this.mRs = getResources();
		 
		 return inflater.inflate(R.layout.fragment_gifts);
    }
	 
	 public void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			this.getSupportActionBar().setTitle(mRs.getString(R.string.gift));
		}
}
