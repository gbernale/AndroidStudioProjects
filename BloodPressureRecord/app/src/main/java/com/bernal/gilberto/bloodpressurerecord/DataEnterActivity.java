package com.bernal.gilberto.bloodpressurerecord;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataEnterActivity extends Activity {
    EditText editTextSystolic;
    EditText editTextDiastolic;
    EditText editTextPulse;
    EditText editTextDate;
    EditText editTextComments;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_enter_activity);
        editTextSystolic = (EditText) findViewById(R.id.et_systolic);
        editTextDiastolic = (EditText) findViewById(R.id.et_diastolic);
        editTextPulse = (EditText) findViewById(R.id.et_pulse);
        editTextDate = (EditText) findViewById(R.id.et_date);
        editTextComments = (EditText) findViewById(R.id.et_comments);




    }
    public void onClickAdd (View btnAdd) {
        String ssystolic = editTextSystolic.getText().toString();
        String sdiastolic = editTextDiastolic.getText().toString();
        String spulse = editTextPulse.getText().toString();
        String sdate = editTextDate.getText().toString();
        String scomments = editTextComments.getText().toString();

        if ( ssystolic.length() != 0 && sdiastolic.length() != 0 ) {
            Intent newIntent = getIntent();
            newIntent.putExtra("tag_bcr_systolic", ssystolic);
            newIntent.putExtra("tag_bcr_diastolic", sdiastolic);
            newIntent.putExtra("tag_bcr_pulse", spulse);
            newIntent.putExtra("tag_bcr_date", sdate);
            newIntent.putExtra("tag_bcr_comments", scomments);
            this.setResult(RESULT_OK, newIntent);
            finish();
        }
    }
}


