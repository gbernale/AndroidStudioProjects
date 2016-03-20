package com.smile.gilberto.tabdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Registered User on 3/17/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

     ArrayList<Fragment> myfragment = new ArrayList<>();
     ArrayList<String> tabTitles = new ArrayList<>();

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

    public CharSequence getPageTile(int  position)
    {
       return tabTitles.get(position);
    }
}
