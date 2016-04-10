package com.smile.gilberto.fragmentsexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements ToolbarFragment.ToolbarListener{
    TextFragment textFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        textFragment = new TextFragment();
        fragmentTransaction.add(R.id.fragment_container2, textFragment);
        TextView textview1 = (TextView)findViewById(R.id.textView1);
        fragmentTransaction.commit();


        FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        ToolbarFragment toolbarFragment = new ToolbarFragment();
        fragmentTransaction2.add(R.id.fragment_container1, toolbarFragment);
        EditText textview2 = (EditText)findViewById(R.id.editText1);
        fragmentTransaction2.commit();
    }


    @Override
    public void onButtonClick(int fontsize , String textview) {

         textFragment.changeTextProperties(fontsize, textview);

       }

}
