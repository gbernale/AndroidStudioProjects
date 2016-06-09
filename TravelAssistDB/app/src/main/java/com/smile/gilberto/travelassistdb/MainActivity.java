package com.smile.gilberto.travelassistdb;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView travelItem_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,TravelItemDetail.class);
            intent.putExtra("travelItem_Id",0);
            startActivity(intent);


        }else {

            TravelRepo repo = new TravelRepo(this);

            ArrayList<HashMap<String, String>> travelitemList =  repo.getTravelItemList();
            if(travelitemList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        travelItem_Id = (TextView) view.findViewById(R.id.item_Id);
                        String itemId = travelItem_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),TravelItemDetail.class);
                        objIndent.putExtra("item_Id", Integer.parseInt( itemId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                        travelitemList,
                        R.layout.view_travelitem_entry,
                        new String[]{"item_id", "item_name", "item_status"},
                        new int[]{R.id.item_Id, R.id.item_name, R.id.item_status});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No travel Item !!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }
}

