package com.kitesong;


import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kitesong.controller.MoreEntrance;
import com.kitesong.model.broadcast.LoginBroadcastReceiver;
import com.kitesong.model.service.LoginService;

public class Kitesong extends Activity {
	
	private LinearLayout mEntrance = null;

    //login button
    private Button mLoginBtn = null;
    
    //username or email
    private EditText mUsername = null;
    
    //password 
    private EditText mPassword = null;
    
    //login tip textView
    private TextView mTipTextView = null;
    
    private Resources rs = null;
    
    public static final int LOGIN_REQUEST_CODE = 0x1;
    
    //BroadcastReceiver 
    public static final String LOGIN_ACTION = Kitesong.class.getName() + ".Login";
    
    private LoginBroadcastReceiver mLoginReceiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitesong);
		
		this.rs = this.getResources();
		
		this.mEntrance = (LinearLayout) this.findViewById(R.id.more_entrance_btn);
		
		this.mEntrance.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Kitesong.this, MoreEntrance.class);
				startActivity(intent);
			}
		});
		
		
		this.mUsername = (EditText) this.findViewById(R.id.username);
		
		this.mPassword = (EditText) this.findViewById(R.id.password);

        this.mLoginBtn = (Button)this.findViewById(R.id.login);
        
        this.mTipTextView = (TextView) this.findViewById(R.id.login_error_tip);
        
       

        this.mLoginBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Kitesong.this, Waiting.class);
                startActivity(intent);*/
            	
            	String username = mUsername.getText().toString();
            	String password = mPassword.getText().toString();
            	
            	if (username == null || username.trim().equals("")) {
            		mTipTextView.setText(rs.getString(R.string.input_username));
            		return;
            	}
            	
            	if (password == null || password.trim().equals("")) {
            		mTipTextView.setText(rs.getString(R.string.input_password));
            		return;
            	}
            	
            	mTipTextView.setText("");
            	
            	Intent intent = new Intent(Kitesong.this,LoginService.class);
            	
            	Bundle data = new Bundle();
            	data.putString("username", username);
            	data.putString("password",password);
            	
            	intent.putExtra("data", data);
            	
            	startService(intent);
            }
        });
        
      
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kitesong, menu);
		return true;
	}

	@Override
	protected void onStart() {
		  //register broadcast receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(LOGIN_ACTION);
        
        mLoginReceiver = new LoginBroadcastReceiver(mTipTextView,this);
        this.registerReceiver(mLoginReceiver, filter);
		super.onStart();
	}

	@Override
	protected void onStop() {
        this.unregisterReceiver(mLoginReceiver);
		super.onStop();
	}
	
	
	
}
