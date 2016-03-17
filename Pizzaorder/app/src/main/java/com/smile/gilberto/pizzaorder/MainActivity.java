package com.smile.gilberto.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   public static  TextView resultview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener ();
    }

    public void OnClickButtonListener ()
    {
         final EditText smalltxt = (EditText)findViewById(R.id.smallpz);
        final EditText mediumtxt = (EditText)findViewById(R.id.mediumpz);
        final EditText largetxt = (EditText)findViewById(R.id.largepz);
        final EditText saladetxt = (EditText)findViewById(R.id.salads);
        final Button button_order = (Button)findViewById(R.id.button);
        final Button cancel_order = (Button)findViewById(R.id.button2);
        resultview = (TextView)findViewById(R.id.total);
        button_order.setOnClickListener(new View.OnClickListener()
        {
            public void onClick( View v)
            {
                int Nsmallpizzas = Integer.parseInt(smalltxt.getText().toString());
                int Nmediumpizzas = Integer.parseInt(mediumtxt.getText().toString());
                int Nlargepizzas = Integer.parseInt(largetxt.getText().toString());
                int Nsalades = Integer.parseInt(saladetxt.getText().toString());
                int suma = 0;
                suma = (Nsmallpizzas * 15 ) + (Nmediumpizzas * 20) + (Nlargepizzas * 25) + (Nsalades * 8 ) ;
                resultview.setText(Integer.toString(suma));
            }
        }
        );
        cancel_order.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                OnClickButtonListener();
            }
        }
        );
    }
}
