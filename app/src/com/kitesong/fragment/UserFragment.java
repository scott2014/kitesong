package com.kitesong.fragment;

import java.util.ArrayList;
import java.util.List;

import org.holoeverywhere.app.Fragment;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.kitesong.R;
import com.kitesong.model.UserPagerAdapter;

public class UserFragment extends Fragment {
	
	@Override
    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user);
        
        View v1 = inflater.inflate(R.layout.user_item_profile);
        View v2 = inflater.inflate(R.layout.user_item_fancy);
        View v3 = inflater.inflate(R.layout.user_item_lists);
        
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
        
        ViewPager pager = (ViewPager)view.findViewById(R.id.viewpager);
        pager.setAdapter(pagerAdapter);
        
        return view;
	}
}
