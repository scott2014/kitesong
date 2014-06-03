package com.kitesong.controller;

import android.app.Activity;
import android.os.Bundle;

import com.kitesong.R;


//Nothing to do except popup window...

public class Waiting extends Activity {
	
		public static Waiting instance = null;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        this.setContentView(R.layout.waiting);
	        
	        instance = this;
	    }
}
