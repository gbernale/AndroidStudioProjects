//package com.smile.gilberto.tabdemo;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.provider.ContactsContract;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
///**
// * Created by Registered User on 3/27/16.
// */
//public class  DataEnterMain extends Activity {
//
//private ActivityCursorAdapter customAdapter;
//private VacationsDatabaseHelper databaseHelper;
//private static final int ENTER_DATA_REQUEST_CODE = 1;
//private ListView listView;
//
//private static final String TAG = DataEnterMain.class.getSimpleName();
///**
// * Called when the activity is first created.
// */
//@Override
//  public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//  final VacationsDatabaseHelper databaseHelper = new VacationsDatabaseHelper(this);
//
//        listView = (ListView) findViewById(R.id.list_data);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//     @Override
//     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Log.d(TAG, "clicked on item: " + position);
//        }
//     });
//
//        // Database query can be a time consuming task ..
//        // so its safe to call database query
//        // in another thread
//        // Handler, will handle this stuff for you <img src="http://s0.wp.com/wp-includes/images/smilies/icon_smile.gif?m=1129645325g" alt=":)" class="wp-smiley">
//
//        new Handler().post(new Runnable() {
//@Override
//public void run() {
//        customAdapter = new ActivityCursorAdapter(DataEnterMain.this, databaseHelper.getAllData());
//        listView.setAdapter(customAdapter);
//        }
//        });
//        }
//
//public void onClickEnterData(View btnAdd) {
//
//        startActivityForResult(new Intent(this, ActivityDataEnter.class), ENTER_DATA_REQUEST_CODE);
//
//        }
//
//@Override
//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == ENTER_DATA_REQUEST_CODE && resultCode == RESULT_OK) {
//
//        databaseHelper.insertData(data.getExtras().getString("tag_person_name"), data.getExtras().getString("tag_person_pin"));
//
//        customAdapter.changeCursor(databaseHelper.getAllData());
//        }
//        }
//        }
