package com.kitesong.fragment;

import org.holoeverywhere.app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kitesong.R;
import com.kitesong.model.ActivityAdapter;

public class ActivityFragment  extends Fragment {
	
	private PullToRefreshListView mListView = null;
	
	private Resources mRs = null;
	
	 @Override
	    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	       View rootView = inflater.inflate(R.layout.fragment_activity);
	       
	       ActivityAdapter adapter = new ActivityAdapter(this.getActivity());
	       
	       this.mListView = (PullToRefreshListView) rootView.findViewById(R.id.pull_refresh_list);
	       
	       this.mListView.setAdapter(adapter);
	       
	       this.mRs = getResources();
	       
	       return rootView;
	    }
	 
	 
	 public void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			this.getSupportActionBar().setTitle(mRs.getString(R.string.activity));
		}
}
