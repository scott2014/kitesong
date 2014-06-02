package com.kitesong.model.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import com.kitesong.model.task.LoginTask;

public class LoginService extends Service {
	
	String mUsername = null;
	String mPassword = null;
	
	private LoginBinder mBinder = new LoginBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Bundle data = intent.getBundleExtra("data");
        this.mUsername = data.getString("username");
        this.mPassword = data.getString("password");
		
		return 0;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}
	
	
	public class LoginBinder extends Binder {
		
		public void login() {
			LoginTask task = new LoginTask();
			task.execute(mUsername,mPassword);
		}
	}
}
