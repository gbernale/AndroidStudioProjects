package com.smile.gilberto.tabdemo;

/*  Developed by  Gilberto Bernal
*   Date :  April 2016   */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.smile.gilberto.tabdemo.R;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {

    ListView myList;
    private View view;
    Button getChoice, clearAll;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyTravelcheckList";
    ArrayList<String> selectedItems = new ArrayList<String>();

    public PersonalFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_home, container, false);
        view = inflater.inflate(R.layout.fragment_personal, container, false);
        myList = (ListView) view.findViewById(R.id.list);
        getChoice = (Button) view.findViewById(R.id.getchoice);
        clearAll = (Button) view.findViewById(R.id.clearall);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.Travel_List));
        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
        sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(MyPREFERENCES)) {
            LoadSelections();
        }
        getChoice.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View v) {

                String selected = "";
                int cntChoice = myList.getCount();

                SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();
                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {
                        selected += myList.getItemAtPosition(i).toString() + "\n";
                        System.out.println("Checking list while adding:" + myList.getItemAtPosition(i).toString());
                        SaveSelections();
                    }

                }

                // Toast.makeText(CheckboxSharedPreferences.this, selected, Toast.LENGTH_LONG).show();

            }
        });

        clearAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ClearSelections();
            }
        });
        return view;
    }


    private void SaveSelections() {
// save the selections in the shared preference in private mode for the user

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES.toString(), savedItems);
        prefEditor.commit();
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.myList.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.myList.getItemAtPosition(i);
                } else {
                    savedItems += this.myList.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }

    private void LoadSelections() {
// if the selections were previously saved load them

        if (sharedpreferences.contains(MyPREFERENCES.toString())) {

            String savedItems = sharedpreferences.getString(MyPREFERENCES.toString(), "");
            selectedItems.addAll(Arrays.asList(savedItems.split(",")));

            int count = this.myList.getAdapter().getCount();

            for (int i = 0; i < count; i++) {
                String currentItem = (String) myList.getAdapter()
                        .getItem(i);
                if (selectedItems.contains(currentItem)) {
                    myList.setItemChecked(i, true);
                    Toast.makeText(getContext(),
                            "Curren Item: " + currentItem,
                            Toast.LENGTH_LONG).show();
                } else {
                    myList.setItemChecked(i, false);
                }

            }
        }
    }

    private void ClearSelections() {
        // user has clicked clear button so uncheck all the items
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            this.myList.setItemChecked(i, false);
        }
// also clear the saved selections
        SaveSelections();
    }
}
