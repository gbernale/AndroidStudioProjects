package com.bernal.gilberto.bloodpressurerecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Registered User on 8/22/2016.
 */
public class CreateDBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "bloodpressure.db";

    public CreateDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_TRAVEL_ITEMS = "CREATE TABLE " + bprecords.TABLE + "("
                + bprecords.KEY_item_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + bprecords.KEY_systolic + " TEXT, "
                + bprecords.KEY_diastolic + " INTEGER, "
                + bprecords.KEY_pulse + " INTEGER, "
                + bprecords.KEY_date + " INTEGER, "
                + bprecords.KEY_comments + " TEXT )";

        db.execSQL(CREATE_TABLE_TRAVEL_ITEMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + bprecords.TABLE);

        // Create tables again
        onCreate(db);

    }
}
