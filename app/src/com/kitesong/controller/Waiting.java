package com.kitesong.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.kitesong.R;
import com.kitesong.model.service.LoginService;

public class Waiting extends Activity {
	
		private LoginService.LoginBinder binder = null;
		
		private ServiceConnection conn = new ServiceConnection() {

			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				
			}
			
		};
		
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        this.setContentView(R.layout.waiting);
	        
	        //Control login by service
	        
	        
	      
	    }
}
