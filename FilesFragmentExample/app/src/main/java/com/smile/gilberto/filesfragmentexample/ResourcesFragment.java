package com.smile.gilberto.filesfragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Registered User on 4/9/16.
 */
public class ResourcesFragment extends Fragment {


    public ResourcesFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_resources, container, false);

        InputStream is = getResources().openRawResource(R.raw.resources);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                entireFile += (line + "\n"); // <---------- add each line to entireFile

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TextView text = null;
        //text.setText(entireFile); // <------- assign entireFile to TextView
        //assert text != null;
        if (text != null) {
            text.setText(entireFile);
        }

        //return rootView;
        return rootView;

    }

}