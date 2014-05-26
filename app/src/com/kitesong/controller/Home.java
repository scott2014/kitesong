package com.kitesong.controller;

import org.holoeverywhere.addon.AddonSlider;
import org.holoeverywhere.addon.Addons;
import org.holoeverywhere.app.Activity;
import org.holoeverywhere.slider.SliderItem;
import org.holoeverywhere.slider.SliderMenu;

import android.os.Bundle;

import com.kitesong.R;
import com.kitesong.fragment.ActivityFragment;
import com.kitesong.fragment.GiftsFragment;
import com.kitesong.fragment.MainFragment;
import com.kitesong.fragment.ShopFragment;
import com.kitesong.fragment.UserFragment;

@Addons(AddonSlider.class)
public class Home extends Activity {

    public AddonSlider.AddonSliderA addonSlider() {
        return addon(AddonSlider.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AddonSlider.AddonSliderA sliderA = addonSlider();
        
        final SliderMenu sliderMenu = sliderA.obtainDefaultSliderMenu(R.layout.menu);
        
        sliderA.setOverlayActionBar(false);
        
        SliderItem myItem = new SliderItem();
        sliderMenu.add(myItem).fillColors(SliderMenu.BLUE);
        myItem.setCustomLayout(R.layout.custom_menu_item);
        myItem.setIcon(R.drawable.ic_launcher);
        myItem.setLabel("Scott");
        myItem.setFragmentClass(UserFragment.class);
        
        sliderMenu.add(R.string.home, MainFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.activity, ActivityFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.gift, GiftsFragment.class,SliderMenu.BLUE);
        sliderMenu.add(R.string.shop, ShopFragment.class,SliderMenu.BLUE);
        
    }
}
