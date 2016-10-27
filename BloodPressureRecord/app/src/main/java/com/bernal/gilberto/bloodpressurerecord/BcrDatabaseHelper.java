package com.bernal.gilberto.bloodpressurerecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Registered User on 9/30/2016.
 */

public class BcrDatabaseHelper {
    private static final String TAG = BcrDatabaseHelper.class.getSimpleName();
    // database configuration
// if you want the onUpgrade to run then change the database_version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "healthdb.db";
    // table configuration
    private static final String TABLE_NAME = "bcr_table"; // Table name
    private static final String BCR_TABLE_COLUMN_ID = "_id"; // a column named "_id" is required for cursor
    private static final String BCR_TABLE_COLUMN_SYST = "bcr_systolic";
    private static final String BCR_TABLE_COLUMN_DIAST = "bcr_diastolic";
    private static final String BCR_TABLE_COLUMN_PULSE = "bcr_pulse";
    private static final String BCR_TABLE_COLUMN_DDATE = "bcr_date";
    private static final String BCR_TABLE_COLUMN_COMMENTS = "bcr_comments";

    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase database;
    // this is a wrapper class. that means, from outside world, anyone will communicate with PersonDatabaseHelper,
// but under the hood actually DatabaseOpenHelper class will perform database CRUD operations
    public BcrDatabaseHelper(Context aContext) {
        openHelper = new DatabaseOpenHelper(aContext);
        database = openHelper.getWritableDatabase();
    }
    public void insertData (String aBcrSystolic, String aBcrDiastolic, String aBcrPulse, String aBcrDate, String aBcrComments) {
// we are using ContentValues to avoid sql format errors
        ContentValues contentValues = new ContentValues();
        contentValues.put(BCR_TABLE_COLUMN_SYST, aBcrSystolic);
        contentValues.put(BCR_TABLE_COLUMN_DIAST, aBcrDiastolic);
        contentValues.put(BCR_TABLE_COLUMN_PULSE, aBcrPulse);
        contentValues.put(BCR_TABLE_COLUMN_DDATE, aBcrDate);
        contentValues.put(BCR_TABLE_COLUMN_COMMENTS, aBcrComments);
        database.insert(TABLE_NAME, null, contentValues);
    }
    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + TABLE_NAME;
        Log.d(TAG, "getAllData SQL: " + buildSQL);
        return database.rawQuery(buildSQL, null);
    }

    public Cursor getDataforGraph () {
        String buildSQL = "SELECT "+BCR_TABLE_COLUMN_SYST+BCR_TABLE_COLUMN_DIAST+" FROM " + TABLE_NAME+"ORDER BY "+BCR_TABLE_COLUMN_DDATE;
        Log.d(TAG, "getDataforGraph SQL: " + buildSQL);
        return database.rawQuery(buildSQL, null);
    }
    // this DatabaseOpenHelper class will actually be used to perform database related operation
    private class DatabaseOpenHelper extends SQLiteOpenHelper {
        public DatabaseOpenHelper(Context aContext) {
            super(aContext, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
// Create your tables here
            String buildSQL = "CREATE TABLE " + TABLE_NAME + "( " + BCR_TABLE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    BCR_TABLE_COLUMN_SYST + " TEXT, " + BCR_TABLE_COLUMN_DIAST + " TEXT, " + BCR_TABLE_COLUMN_PULSE + " TEXT, " + BCR_TABLE_COLUMN_DDATE + " TEXT, " + BCR_TABLE_COLUMN_COMMENTS + " TEXT    )";

            Log.d(TAG, "onCreate SQL: " + buildSQL);
            sqLiteDatabase.execSQL(buildSQL);
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
// Database schema upgrade code goes here
            String buildSQL = "DROP TABLE IF EXISTS " + TABLE_NAME;
            Log.d(TAG, "onUpgrade SQL: " + buildSQL);
            sqLiteDatabase.execSQL(buildSQL); // drop previous table
            onCreate(sqLiteDatabase); // create the table from the beginning
        }
    }
}

