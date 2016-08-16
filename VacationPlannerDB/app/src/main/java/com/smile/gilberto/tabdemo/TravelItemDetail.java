package com.smile.gilberto.tabdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smile.gilberto.tabdemo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/*
 * Created by Gilberto Bernal
 * Registered User on 8/12/16.
 */
public class TravelItemDetail  extends ActionBarActivity {

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextStatus;
    EditText editTextDate;
    EditText editTextComments;
    public static final long MAGIC=86400000L;

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

        _Travel_Items_Id =0;
        Intent intent = getIntent();
        _Travel_Items_Id =intent.getIntExtra("item_Id", 0);
        TravelRepo repo = new TravelRepo(this);
        Travel_Items travel_item = new Travel_Items();
        travel_item = repo.getTravelistById(_Travel_Items_Id);

        Calendar c = Calendar.getInstance();
        final String sDate = c.get(Calendar.YEAR) + "-"
                + (c.get(Calendar.MONTH)+1)
                + "-" + c.get(Calendar.DAY_OF_MONTH);

        if(travel_item.item_status==null) travel_item.item_status=0;
        else editTextStatus.setText(String.valueOf(travel_item.item_status));
        //editTextDate.setText(String.valueOf(travel_item.item_date));
        if ( travel_item.item_date !=null) {
            editTextDate.setText(String.valueOf(travel_item.item_date));
            }
        else editTextDate.setText(sDate);

        editTextName.setText(travel_item.item_name);
        editTextComments.setText(travel_item.item_comments);
        //btnDelete.setOnClickListener(getApplication() );

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      String  ssDate =sDate.replace("-", "");
                      if (view == findViewById(R.id.btnSave)){
                        TravelRepo repo = new TravelRepo(getApplication());
                        Travel_Items travel_item = new Travel_Items();
                        //travel_item.item_date= Integer.parseInt(editTextDate.getText().toString());
                        travel_item.item_date=new Integer(Integer.parseInt(ssDate));
                        travel_item.item_comments=editTextComments.getText().toString();
                        travel_item.item_status=Integer.parseInt(editTextStatus.getText().toString());
                        travel_item.item_name=editTextName.getText().toString();
                        travel_item.item_ID=_Travel_Items_Id;

                        if (_Travel_Items_Id==0){

                            _Travel_Items_Id = repo.insert(travel_item);
                            Toast.makeText(getApplication(),"New Document Insert",Toast.LENGTH_SHORT).show();
                            finish();
                        }else{

                            repo.update(travel_item);
                            Toast.makeText(getApplication(),"Travel Item Record updated",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }/*else if (view== findViewById(R.id.btnDelete)){
                        TravelRepo repo = new TravelRepo(getApplication());
                        repo.delete(_Travel_Items_Id);
                        Toast.makeText(getApplication(), "Travel Item Record Deleted", Toast.LENGTH_SHORT);
                        finish();
                    }else if (view== findViewById(R.id.btnClose)){
                        finish();
                    }*/



            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

               TravelRepo repo = new TravelRepo(getApplication());
               repo.delete(_Travel_Items_Id);
               Toast.makeText(getApplication(), "Travel Item Record Deleted", Toast.LENGTH_SHORT);
               finish();}});

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

   /* public void onClick(View view) {
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


    } */

}
