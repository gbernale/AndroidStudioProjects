package com.smile.gilberto.tabdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DocsFragment extends Fragment {

    private final static String STORETEXT="vacationlist1.txt";
    private static EditText txtEditor;
    private View view;
    private Button btnsave;

    public DocsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_docs, container, false);
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
            Toast.makeText(getActivity(), "Your data has been saved in the file: " +
                    getActivity().getFilesDir().getAbsolutePath(), Toast.LENGTH_LONG).show();
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