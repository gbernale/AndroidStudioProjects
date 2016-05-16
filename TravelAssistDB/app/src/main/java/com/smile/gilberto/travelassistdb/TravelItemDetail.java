package com.smile.gilberto.travelassistdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Registered User on 5/9/16.
 */
public class TravelItemDetail
        extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextStatus;
    EditText editTextDate;
    EditText editTextComments;

    private int _Travel_Items_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_item_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextitemName);
        editTextStatus = (EditText) findViewById(R.id.editTextitemStatus);
        editTextDate = (EditText) findViewById(R.id.editTextitemDate);
        editTextComments = (EditText) findViewById(R.id.editTextitemComments);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Travel_Items_Id =0;
        Intent intent = getIntent();
        _Travel_Items_Id =intent.getIntExtra("item_Id", 0);
        TravelRepo repo = new TravelRepo(this);
        Travel_Items travel_item = new Travel_Items();
        travel_item = repo.getTravelistById(_Travel_Items_Id);

        editTextStatus.setText(String.valueOf(travel_item.item_status));
        editTextDate.setText(String.valueOf(travel_item.item_date));
        editTextName.setText(travel_item.item_name);
        editTextComments.setText(travel_item.item_comments);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            //StudentRepo repo = new StudentRepo(this);
            TravelRepo repo = new TravelRepo(this);
            //Student student = new Student();
            Travel_Items travel_item = new Travel_Items();
            travel_item.item_date= Integer.parseInt(editTextDate.getText().toString());
            travel_item.item_comments=editTextComments.getText().toString();
            travel_item.item_status=Integer.parseInt(editTextStatus.getText().toString());
            travel_item.item_name=editTextName.getText().toString();
            travel_item.item_ID=_Travel_Items_Id;

            if (_Travel_Items_Id==0){

                _Travel_Items_Id = repo.insert(travel_item);

                Toast.makeText(this,"New Document Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(travel_item);
                Toast.makeText(this,"Travel Item Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            TravelRepo repo = new TravelRepo(this);
            repo.delete(_Travel_Items_Id);
            Toast.makeText(this, "Travel Item Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}
