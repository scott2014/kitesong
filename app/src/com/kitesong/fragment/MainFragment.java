package com.kitesong.fragment;

import org.holoeverywhere.app.Fragment;
import org.holoeverywhere.widget.Toast;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kitesong.R;
import com.kitesong.model.MainAdapter;

public class MainFragment extends Fragment {
	
	private PullToRefreshListView mListView = null;
	
	//Adapter
	private MainAdapter mMainAdapter = null;
	
	private Resources rs = null;

    @Override
    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	View rootView = inflater.inflate(R.layout.fragment_main);
    	
    	this.mListView = (PullToRefreshListView) rootView.findViewById(R.id.pull_refresh_list);
    	
    	this.mListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("正在刷新");
			}
    	});
    	
    	this.mListView.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

			@Override
			public void onLastItemVisible() {
				Toast.makeText(getActivity(),"last", Toast.LENGTH_SHORT).show();
			}
    		
    	});
    	
    	
    	this.mMainAdapter = new MainAdapter(getActivity());
    	
    	this.mListView.setAdapter(mMainAdapter);
    	
    	this.rs = this.getResources();
    	
        return rootView;
    }
    
    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			super.onPostExecute(result);
		}
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.getSupportActionBar().setTitle(rs.getString(R.string.home));
		this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		this.getSupportActionBar().setDisplayShowHomeEnabled(true);
	}
    
    
}
