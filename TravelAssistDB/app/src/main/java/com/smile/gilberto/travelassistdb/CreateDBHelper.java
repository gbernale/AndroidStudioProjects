package com.smile.gilberto.travelassistdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Registered User on 5/9/16.
 */
public class CreateDBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "travel.db";

    public CreateDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_TRAVEL_ITEMS = "CREATE TABLE " + Travel_Items.TABLE + "("
                + Travel_Items.KEY_item_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Travel_Items.KEY_item_name + " TEXT, "
                + Travel_Items.KEY_item_status + " INTEGER, "
                + Travel_Items.KEY_item_date + " INTEGER, "
                + Travel_Items.KEY_item_comments + " TEXT )";

        db.execSQL(CREATE_TABLE_TRAVEL_ITEMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Travel_Items.TABLE);

        // Create tables again
        onCreate(db);

    }
}
