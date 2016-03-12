package com.smile.gilberto.basicoperations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view){

        EditText N1 = (EditText)findViewById(R.id.Number1);
        EditText N2 = (EditText)findViewById(R.id.Number2);
        TextView R1 = ( TextView)findViewById(R.id.Result);
        int Num1 = Integer.parseInt(N1.getText().toString());
        int Num2 = Integer.parseInt(N2.getText().toString());
        int suma = Num1 + Num2;
        R1.setText(Integer.toString(suma));
    };
}
