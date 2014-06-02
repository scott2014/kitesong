package com.kitesong;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kitesong.controller.Home;
import com.kitesong.controller.MoreEntrance;
import com.kitesong.controller.Waiting;
import com.kitesong.model.constant.LoginStatus;

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
            	
            	Intent intent = new Intent(Kitesong.this,Waiting.class);
            	
            	Bundle data = new Bundle();
            	data.putString("username", username);
            	data.putString("password",password);
            	
            	intent.putExtra("data", data);
            	
            	startActivityForResult(intent,LOGIN_REQUEST_CODE);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kitesong, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == LOGIN_REQUEST_CODE) {
			if (resultCode == LoginStatus.CONNECT_FAIL) {
				this.mTipTextView.setText(rs.getString(R.string.connect_fail));
			}
			
			if (resultCode == LoginStatus.USER_NOT_EXIST) {
				this.mTipTextView.setText(rs.getString(R.string.user_not_exist));
			}
			
			if (resultCode == LoginStatus.PASSWORD_NOT_CORRECT) {
				this.mTipTextView.setText(rs.getString(R.string.password_not_correct));
			}
			
			if (resultCode == LoginStatus.LOGIN_OK) {
				Intent intent = getIntent();
				intent.setClass(this, Home.class);
				startActivity(intent);
			}
		}
	}
	
	

}
