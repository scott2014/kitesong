package com.kitesong.controller;

import org.holoeverywhere.addon.AddonSlider;
import org.holoeverywhere.addon.Addons;
import org.holoeverywhere.app.Activity;
import org.holoeverywhere.slider.SliderMenu;

import android.os.Bundle;

import com.kitesong.R;
import com.kitesong.fragment.MainFragment;

@Addons(AddonSlider.class)
public class Home extends Activity {

    public AddonSlider.AddonSliderA addonSlider() {
        return addon(AddonSlider.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SliderMenu sliderMenu = addonSlider().obtainDefaultSliderMenu(R.layout.menu);
        
        sliderMenu.add(R.string.home, MainFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.activity, MainFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.gift, MainFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.shop, MainFragment.class,SliderMenu.BLUE);
        
       /* sliderMenu.add(R.string.app_name, MainFragment.class,SliderMenu.BLUE);

        getSupportActionBar().setTitle(R.string.app_name);*/

     //   ((FrameLayout)findViewById(R.id.fr)).setacti
    }
}
