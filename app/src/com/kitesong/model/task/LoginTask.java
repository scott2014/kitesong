package com.kitesong.model.task;

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

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.kitesong.Kitesong;
import com.kitesong.controller.Waiting;
import com.kitesong.model.constant.UrlConst;

public class LoginTask extends AsyncTask<String, Object, String> {
	
	private Context mContext = null;
	
	public LoginTask(Context context) {
		this.mContext = context;
	}

	@Override
	protected String doInBackground(String... args) {

		String username = args[0];
		String password = args[1];

		HttpPost post = new HttpPost(UrlConst.LOGIN);

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		NameValuePair n1 = new BasicNameValuePair("loginStr", username);
		NameValuePair n2 = new BasicNameValuePair("password", password);

		params.add(n1);
		params.add(n2);

		HttpEntity entity = null;

		HttpResponse response = null;

		HttpClient client = new DefaultHttpClient();
		
		StringBuilder result = new StringBuilder("");
		
		try {
			entity = new UrlEncodedFormEntity(params, "utf8");

			post.setEntity(entity);

			response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				InputStream is = response.getEntity().getContent();

				String str = null;

				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));

				while ((str = br.readLine()) != null) {
					result.append(str);
				}

				is.close();
				br.close();

			}

		} catch (UnsupportedEncodingException e) {
			Log.e(LoginTask.class.getName() + "-UnsupportedEncodingException",e.getMessage());
		} catch (ClientProtocolException e) {
			Log.e(LoginTask.class.getName() + "-ClientProtocolException",e.getMessage());
		} catch (IOException e) {
			Log.e(LoginTask.class.getName() + "-IOException", e.getMessage());
		}
		return result.toString();
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		
		Waiting.instance.finish();
		
		Intent intent = new Intent();
		
		intent.putExtra("result",result);
		intent.setAction(Kitesong.LOGIN_ACTION);
		this.mContext.sendBroadcast(intent);
		
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		Intent intent = new Intent(mContext,Waiting.class);
		
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		this.mContext.startActivity(intent);
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	

}
