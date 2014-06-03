package com.kitesong.model.broadcast;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;

import com.kitesong.Kitesong;
import com.kitesong.R;
import com.kitesong.controller.Home;
import com.kitesong.model.constant.LoginStatus;

public class LoginBroadcastReceiver extends BroadcastReceiver {
	
	private TextView mTipText = null;
	
	private Context mContext = null;
	
	public LoginBroadcastReceiver(TextView tipText,Context context) {
		this.mTipText = tipText;
		this.mContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction().equals(Kitesong.LOGIN_ACTION)) {
			Resources rs = context.getResources();
			
			String result = intent.getStringExtra("result");
			
			JSONObject json = null;
			try {
				json = new JSONObject(result);
				
				int code = json.getInt("code");

				switch(code) {
					case LoginStatus.CONNECT_FAIL:
						this.mTipText.setText(rs.getString(R.string.connect_fail));
						break;
					case LoginStatus.USER_NOT_EXIST:
						this.mTipText.setText(rs.getString(R.string.user_not_exist));
						break;
					case LoginStatus.PASSWORD_NOT_CORRECT:
						this.mTipText.setText(rs.getString(R.string.password_not_correct));
						break;
					case LoginStatus.LOGIN_OK:
						Intent i = new Intent();
						
						String username = json.getString("userName");
						String nickname = json.getString("nickname");
						String email = json.getString("email");
						
						i.putExtra("username", username);
						i.putExtra("nickname", nickname);
						i.putExtra("email", email);
						
						i.setClass(context, Home.class);
						
						mContext.startActivity(i);
						break;
					default:
						break;
				}
			} catch (JSONException e) {
				Log.e(LoginBroadcastReceiver.class.getName() + "-JSONException",e.getMessage());
			}
		}
	}

}
