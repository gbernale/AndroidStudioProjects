package com.smile.gilberto.tabdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Registered User on 3/27/16.
 */
public class ActivityDataEnter extends Activity {

    EditText editTextActivityName;
    EditText editTextActivityGroup;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataenter_type_data);

        editTextActivityName = (EditText) findViewById(R.id.et_activity_name);
        editTextActivityGroup = (EditText) findViewById(R.id.et_activity_group);
    }

    public void onClickAdd (View btnAdd) {

        String activityName = editTextActivityName.getText().toString();
        String activityGroup = editTextActivityGroup.getText().toString();

        if ( activityName.length() != 0 && activityGroup.length() != 0 ) {

            Intent newIntent = getIntent();
            newIntent.putExtra("tag_person_name", activityName);
            newIntent.putExtra("tag_person_pin", activityGroup);

            this.setResult(RESULT_OK, newIntent);

            finish();
        }
    }
}

