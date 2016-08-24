package com.smile.gilberto.tabdemo;
/*  Developed by  Gilberto Bernal
*   Date :  August 2016   */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smile.gilberto.tabdemo.DocsFragment;
import com.smile.gilberto.tabdemo.HomeFragment;
import com.smile.gilberto.tabdemo.ViewPagerAdapter;
import com.smile.gilberto.tabdemo.PersonalFragment;
import com.smile.gilberto.tabdemo.R;


public class MainActivity extends AppCompatActivity {
  Toolbar toolb;
  TabLayout tabl;
  ViewPager viewp;
  ViewPagerAdapter viewpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolb = (Toolbar)findViewById(R.id.toolBar);
         setSupportActionBar(toolb);
        tabl = (TabLayout)findViewById(R.id.tabLayout);
        viewp = (ViewPager)findViewById(R.id.viewPager);
        viewpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewpa.addFragments(new HomeFragment(),"Personal Items");
        viewpa.addFragments(new PersonalFragment(),"Documents ");
        viewpa.addFragments(new DocsFragment(),"Expenses");
       // viewpa.addFragments(new PersonalFragment(),"Documents Checklist");
        viewp.setAdapter(viewpa);
        tabl.setupWithViewPager(viewp);

    }
}
