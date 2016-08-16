package com.smile.gilberto.tabdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 * Created by Gilberto Bernal
 * Registered User on 8/12/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

     ArrayList<Fragment> myfragment = new ArrayList<>();
     ArrayList<String> tabTitles = new ArrayList<>();
     //tabTitles.add("Docs");

    public ViewPagerAdapter(FragmentManager fm)
    { super(fm);}

    public void addFragments(Fragment fragments,String titles)
    {
      this.myfragment.add(fragments);
      this.tabTitles.add(titles);
    }



    @Override
    public Fragment getItem(int position) {
        return myfragment.get(position);
    }

    @Override
    public int getCount() {
        return myfragment.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}
