package com.kitesong;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Kitesong extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitesong);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kitesong, menu);
		return true;
	}

}
