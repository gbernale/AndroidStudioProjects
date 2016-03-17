package com.smile.gilberto.fragmentsruntime;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.reg_user);
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        loginFragment loginfr = new loginFragment();
        FT.add(R.id.fragment_container, loginfr);
        FT.commit();
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM2 = getFragmentManager();
                FragmentTransaction FT2 = FM2.beginTransaction();
                registerFragment registerfr = new registerFragment();
                FT2.replace(R.id.fragment_container, registerfr);
                FT2.commit();
            }
        });


    }
}
