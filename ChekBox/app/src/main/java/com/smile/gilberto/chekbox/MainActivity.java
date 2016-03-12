package com.smile.gilberto.chekbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox check1, check2, check3;
    private Button button_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListnerToButton();
        addListenerToCheckBox();
    }

    public void addListenerToCheckBox()
    {    check1 = (CheckBox)findViewById(R.id.check_dog);
        check1.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this, " Dog is Selected ", Toast.LENGTH_LONG).show();
                }
            }
        }
    );
    }


    public void addListnerToButton()
    {    check1 = (CheckBox)findViewById(R.id.check_dog);
         check2 = (CheckBox)findViewById(R.id.check_cat);
         check3 = (CheckBox)findViewById(R.id.check_cow);
        button_selected = (Button)findViewById(R.id.button);
        button_selected.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StringBuffer result = new StringBuffer();
                result.append("\nDog : ").append(check1.isChecked());
                result.append("\nCat : ").append(check2.isChecked());
                result.append("\nCow : ").append(check3.isChecked());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }

        }
    );
    }
}

