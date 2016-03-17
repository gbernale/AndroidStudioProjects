package com.smile.gilberto.twofragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by Registered User on 3/13/16.
 */
public class FragmentOne extends Fragment {
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
   View v = inflater.inflate(R.layout.fragment_one_layout,container,false);
   return v;
   }
}
