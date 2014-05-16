package com.kitesong;

import org.holoeverywhere.HoloEverywhere;
import org.holoeverywhere.ThemeManager;
import org.holoeverywhere.HoloEverywhere.PreferenceImpl;
import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Application;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;

public class KitesongApplication extends Application {

	static {
		HoloEverywhere.DEBUG = true;
		HoloEverywhere.PREFERENCE_IMPL = PreferenceImpl.JSON;
		
		LayoutInflater.registerPackage(KitesongApplication.class.getPackage().getName());
		
		ThemeManager.setDefaultTheme(ThemeManager.MIXED);
		
		if (VERSION.SDK_INT  >= VERSION_CODES.HONEYCOMB) {
			ThemeManager.modify(ThemeManager.FULLSCREEN);
		}
		
		//ThemeManager.map(ThemeManager.DARK,R.style)
	}
}
