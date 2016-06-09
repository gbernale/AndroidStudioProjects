package com.smile.gilberto.tabdemo;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.smile.gilberto.tabdemo.R;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class DocsFragment extends Fragment {

  private View view;
    public DocsFragment() {
        // Required empty public constructor
    }

    Button btnAdd,btnGetAll;
    TextView travelItem_Id;
    ListView lv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_home, container, false);
        view = inflater.inflate(R.layout.fragment_docs, container, false);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnGetAll = (Button) view.findViewById(R.id.btnGetAll);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TravelItemDetail.class);
                intent.putExtra("travelItem_Id", 0);
                getActivity().startActivity(intent);
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                public void onClick(View v) {

                    TravelRepo repo = new TravelRepo(getActivity());

                    ArrayList<HashMap<String, String>> travelitemList = repo.getTravelItemList();
                    if (travelitemList.size() != 0) {

                        ListView lv = (ListView)view.findViewById(R.id.list);

                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                travelItem_Id = (TextView) view.findViewById(R.id.item_Id);
                                String itemId = travelItem_Id.getText().toString();
                                Intent objIndent = new Intent(getActivity(), TravelItemDetail.class);
                                objIndent.putExtra("item_Id", Integer.parseInt(itemId));
                                startActivity(objIndent);
                        }
                        });

                        ListAdapter adapter = new SimpleAdapter(getActivity(),
                                travelitemList,
                                R.layout.view_travelitem_entry,
                                new String[]{"item_id", "item_name", "item_status"},
                                new int[]{R.id.item_Id, R.id.item_name, R.id.item_status});
                        lv.setAdapter(adapter);


                    } else {

                        Toast.makeText(getActivity(), "No travel Item !!", Toast.LENGTH_SHORT).show();
                    }

                }
             });
        return view;


       // @Override

    }
    }
