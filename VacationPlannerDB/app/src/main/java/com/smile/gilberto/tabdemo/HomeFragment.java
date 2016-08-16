package com.smile.gilberto.tabdemo;

/*  Developed by  Gilberto Bernal
*   Date :  August 2016   */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.smile.gilberto.tabdemo.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;


public class HomeFragment extends Fragment {

    private final static String STORETEXT="vacationlist.txt";
    private static EditText txtEditor;
    private View view;
    private Button btnsave;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_home, container, false);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        txtEditor= (EditText) view.findViewById(R.id.textbox);
        txtEditor.setText(txtEditor.getText().toString());
        btnsave = (Button)view.findViewById(R.id.save);
        readVacationData();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVacationData(view);
            }
        });
        return view;
    }

    public void saveVacationData(View v) {

        try {

            FileOutputStream fileOutputStream = getActivity().openFileOutput(STORETEXT, 0);
            OutputStreamWriter out = new OutputStreamWriter(fileOutputStream);
            out.write(txtEditor.getText().toString());
            out.close();
            Toast.makeText(getActivity(), "Your data has been saved  ", Toast.LENGTH_LONG).show();
        }

        catch (Throwable t) {
            Toast.makeText(getActivity(),"Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void readVacationData()
    {

        try {
            InputStream in = this.getActivity().openFileInput(STORETEXT);


            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str+"\n");
                }
                in.close();
                txtEditor.setText(buf.toString());
            }
        }
        catch (java.io.FileNotFoundException e) {
// that's OK, we probably haven't created it yet
        }
        catch (Throwable t) {
            Toast.makeText(getActivity(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

}

