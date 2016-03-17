package com.smile.gilberto.twofragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =  (Button)findViewById(R.id.button1);
        b2 =  (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      FragmentManager FM = getFragmentManager();
                                      FragmentTransaction FT = FM.beginTransaction();
                                      FragmentOne F1 = new FragmentOne();
                                      FT.add(R.id.fr1_id, F1);
                                      FT.commit();
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentTwo F2 = new FragmentTwo();
                FT.add(R.id.fr2_id, F2);
                FT.commit();
            }
        });

    }
}
