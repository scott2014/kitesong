package com.kitesong.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kitesong.R;
import com.kitesong.model.constant.LoginStatus;
import com.kitesong.model.constant.UrlConst;

public class Waiting extends Activity {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        this.setContentView(R.layout.waiting);
	        
	        Bundle data = getIntent().getBundleExtra("data");
	        final String username = data.getString("username");
	        final String password = data.getString("password");
	        
	        new Thread(new Runnable() {

				@Override
				public void run() {
					  HttpPost post = new HttpPost(UrlConst.LOGIN);
				        
				        List<NameValuePair> params = new ArrayList<NameValuePair>();
				        
				        NameValuePair n1 = new BasicNameValuePair("loginStr",username);
				        NameValuePair n2 = new BasicNameValuePair("password",password);
				        
				        params.add(n1);
				        params.add(n2);
				        
				        HttpEntity entity = null;
				        
				        HttpResponse response = null;
				        
				        HttpClient client = new DefaultHttpClient();
				        
				        try {
							entity = new UrlEncodedFormEntity(params,"utf8");
							
							post.setEntity(entity);
							
							response = client.execute(post);
							
							
							if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
								InputStream is = response.getEntity().getContent();
								
								StringBuilder result = new StringBuilder("");
								
								String str = null;
								
								BufferedReader br = new BufferedReader(new InputStreamReader(is));
								
								while ((str = br.readLine()) != null) {
									result.append(str);
								}
								
								is.close();
								br.close();
								
								JSONObject json = new JSONObject(result.toString());
								
								int code = json.getInt("code");
								
								Intent intent = new Intent();
								
								
								
								switch(code) {
									case LoginStatus.USER_NOT_EXIST:
										setResult(LoginStatus.USER_NOT_EXIST, intent);
										break;
									case LoginStatus.PASSWORD_NOT_CORRECT:
										setResult(LoginStatus.PASSWORD_NOT_CORRECT, intent);
										break;
									case LoginStatus.LOGIN_OK:
										Bundle data = new Bundle();
										data.putString("userName", json.getString("userName"));
										data.putString("nickname", json.getString("nickname"));
										data.putString("email", json.getString("email"));
										setResult(LoginStatus.LOGIN_OK, intent);
										break;
									default:
										break;
								}
								
								Waiting.this.finish();
								
							} else {
								setResult(LoginStatus.CONNECT_FAIL);
								Waiting.this.finish();
							}
							
						} catch (UnsupportedEncodingException e) {
							Log.e(Waiting.class.getName() + "-UnsupportedEncodingException", e.getMessage());
							setResult(LoginStatus.CONNECT_FAIL);
							Waiting.this.finish();
						} catch (ClientProtocolException e) {
							Log.e(Waiting.class.getName() + "-ClientProtocolException", e.getMessage());
							setResult(LoginStatus.CONNECT_FAIL);
							Waiting.this.finish();
						} catch (IOException e) {
							Log.e(Waiting.class.getName() + "-IOException", e.getMessage());
							setResult(LoginStatus.CONNECT_FAIL);
							Waiting.this.finish();
						} catch (JSONException e) {
							Log.e(Waiting.class.getName() + "-JSONException", e.getMessage());
							setResult(LoginStatus.CONNECT_FAIL);
							Waiting.this.finish();
						}
				}
			}).start();
	    }
}
