package com.kitesong.fragment;

import org.holoeverywhere.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.kitesong.R;

public class ActivityFragment  extends Fragment {
	 @Override
	    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        return inflater.inflate(R.layout.fragment_activity);
	    }
}
