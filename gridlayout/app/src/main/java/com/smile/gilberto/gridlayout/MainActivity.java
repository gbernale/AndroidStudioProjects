package com.smile.gilberto.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLogin (View view) {
        TextView name = (TextView) findViewById(R.id.input1);
        String user = name.getText().toString();
        Toast.makeText(this, user+"Bernal is logged in ",
                Toast.LENGTH_LONG).show();
    }



}
