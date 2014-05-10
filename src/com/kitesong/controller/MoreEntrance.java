package com.kitesong.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.kitesong.R;

public class MoreEntrance extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_entrance);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.more_entrance, menu);
		return true;
	}

}
