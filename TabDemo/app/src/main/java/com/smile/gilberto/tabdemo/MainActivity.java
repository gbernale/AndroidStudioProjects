package com.smile.gilberto.tabdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
  Toolbar toolb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolb = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolb);
    }
}
