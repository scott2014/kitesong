package com.kitesong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kitesong.controller.Home;
import com.kitesong.controller.MoreEntrance;

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
                Intent intent = new Intent(Kitesong.this, Home.class);
                startActivity(intent);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kitesong, menu);
		return true;
	}

}
