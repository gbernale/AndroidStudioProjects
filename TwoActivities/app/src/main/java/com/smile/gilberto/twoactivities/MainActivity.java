package com.smile.gilberto.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private static Button button_smt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListener();
    }

    public void onClickButtonListener() {
        button_smt = (Button) findViewById(R.id.button_second_activity);
        button_smt.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              Intent intent = new Intent("com.smile.gilberto.twoactivities.SecondActivity");
                                              startActivity(intent);
                                          }

                                      }
        );
    }

}
