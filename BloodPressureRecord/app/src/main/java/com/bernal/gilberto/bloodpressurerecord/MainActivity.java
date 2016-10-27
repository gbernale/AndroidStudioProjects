package com.bernal.gilberto.bloodpressurerecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static android.app.Activity.RESULT_OK;

public class MainActivity extends Activity {
    private BcrCursorAdapter customAdapter;
    private BcrDatabaseHelper databaseHelper;
    private static final int ENTER_DATA_REQUEST_CODE = 1;
    private ListView listView;
    private static final String TAG = MainActivity.class.getSimpleName();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new BcrDatabaseHelper(this);
        listView = (ListView) findViewById(R.id.list_data);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "clicked on item: " + position);
            }
        });
// Database query can be a time consuming task ..
// so its safe to call database query
// in another thread
// Handler, will handle this stuff for you <img src="http://s0.wp.com/wp-includes/images/smilies/icon_smile.gif?m=1129645325g" alt=":)" class="wp-smiley">
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                customAdapter = new BcrCursorAdapter(MainActivity.this, databaseHelper.getAllData());
                listView.setAdapter(customAdapter);
            }
        });
    }
    public void onClickEnterData(View btnAdd) {
        startActivityForResult(new Intent(this, DataEnterActivity.class), ENTER_DATA_REQUEST_CODE);
    }

    public void onClickViewGraph(View btnGraph) {
        startActivityForResult(new Intent(this, GraphActivity.class), ENTER_DATA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ENTER_DATA_REQUEST_CODE && resultCode == RESULT_OK) {
            databaseHelper.insertData(data.getExtras().getString("tag_bcr_systolic"), data.getExtras().getString("tag_bcr_diastolic"),data.getExtras().getString("tag_bcr_pulse"), data.getExtras().getString("tag_bcr_date"), data.getExtras().getString("tag_bcr_comments" ));
            customAdapter.changeCursor(databaseHelper.getAllData());
        }
    }
}