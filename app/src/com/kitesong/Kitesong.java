package com.kitesong;

import com.kitesong.controller.MoreEntrance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import java.lang.Override;

public class Kitesong extends Activity {
	
	private LinearLayout mEntrance = null;

    //login button
    private Button mLoginBtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitesong);
		
		this.mEntrance = (LinearLayout) this.findViewById(R.id.more_entrance_btn);
		
		this.mEntrance.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Kitesong.this, MoreEntrance.class);
				startActivity(intent);
			}
		});

        this.mLoginBtn = (Button)this.findViewById(R.id.login);

        this.mLoginBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kitesong, menu);
		return true;
	}

}
