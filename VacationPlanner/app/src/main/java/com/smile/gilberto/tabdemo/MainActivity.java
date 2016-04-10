package com.smile.gilberto.tabdemo;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
        viewpa.addFragments(new HomeFragment(),"ID & Documents");
        viewpa.addFragments(new DocsFragment(),"Personal Stuff");
        viewpa.addFragments(new PersonalFragment(),"Places to Visit");
        viewp.setAdapter(viewpa);
        tabl.setupWithViewPager(viewp);

    }
}
