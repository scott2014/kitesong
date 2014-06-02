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
import org.json.JSONException;
import org.json.JSONObject;

import com.kitesong.controller.Waiting;
import com.kitesong.model.constant.UrlConst;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class LoginTask extends AsyncTask<String, Object, Object> {

	@Override
	protected Object doInBackground(String... args) {

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

		try {
			entity = new UrlEncodedFormEntity(params, "utf8");

			post.setEntity(entity);

			response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				InputStream is = response.getEntity().getContent();

				StringBuilder result = new StringBuilder("");

				String str = null;

				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));

				while ((str = br.readLine()) != null) {
					result.append(str);
				}

				is.close();
				br.close();

				JSONObject json = new JSONObject(result.toString());

				int code = json.getInt("code");

				Intent intent = new Intent();

			}

		} catch (UnsupportedEncodingException e) {
			Log.e(Waiting.class.getName() + "-UnsupportedEncodingException",
					e.getMessage());
		} catch (ClientProtocolException e) {
			Log.e(Waiting.class.getName() + "-ClientProtocolException",
					e.getMessage());
		} catch (IOException e) {
			Log.e(Waiting.class.getName() + "-IOException", e.getMessage());
		} catch (JSONException e) {
			Log.e(Waiting.class.getName() + "-JSONException", e.getMessage());
		}
		return null;
	}
	
	
	@Override
	protected void onPostExecute(Object result) {
		
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	

}
