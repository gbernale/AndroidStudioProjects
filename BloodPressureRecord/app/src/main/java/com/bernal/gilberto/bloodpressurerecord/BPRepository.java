package com.bernal.gilberto.bloodpressurerecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Registered User on 8/22/2016.
 */
public class BPRepository {
    private CreateDBHelper dbHelper;

    public BPRepository(Context context) {
        dbHelper = new CreateDBHelper(context);
    }

    public int insert(Travel_Items travel_item ) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(bprecords.KEY_item_name, travel_item.item_name);
        values.put(bprecords.KEY_item_status,travel_item.item_status);
        values.put(bprecords.KEY_item_date, travel_item.item_date);
        values.put(bprecords.KEY_item_comments, travel_item.item_comments);

        // Inserting Row
        long travel_item_Id = db.insert(bprecords.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) travel_item_Id;
    }

    public void delete(int travel_item_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(bprecords.TABLE, bprecords.KEY_item_ID + "= ?", new String[] { String.valueOf(travel_item_Id) });
        db.close(); // Closing database connection
    }

    public void update(bprecords travel_item) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(bprecords.KEY_item_name, travel_item.item_name);
        values.put(bprecords.KEY_item_status,travel_item.item_status);
        values.put(bprecords.KEY_item_date, travel_item.item_date);
        values.put(bprecords.KEY_item_comments, travel_item.item_comments);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(bprecords.TABLE, values, bprecords.KEY_item_ID + "= ?", new String[] { String.valueOf(travel_item.item_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getTravelItemList() {
        //Open connection to read only
        //bprecords travel_item = new bprecords();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                bprecords.KEY_item_ID + "," +
                bprecords.KEY_item_name + "," +
                bprecords.KEY_item_status + "," +
                bprecords.KEY_item_date + "," +
                bprecords.KEY_item_comments +
                " FROM " + bprecords.TABLE;

        //bprecords   travel_item = new bprecords();
        ArrayList<HashMap<String, String>> travelitemList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> travel_item = new HashMap<String, String>();
                travel_item.put("item_id", cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_ID)));
                travel_item.put("item_name", cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_name)));
                travel_item.put("item_Status", cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_status)));
                travel_item.put("item_date", cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_date)));
                travel_item.put("item_comments", cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_comments)));
                travelitemList.add(travel_item);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return travelitemList;
    }

    public bprecords getTravelistById(int Id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                bprecords.KEY_item_ID + "," +
                bprecords.KEY_item_name + "," +
                bprecords.KEY_item_status + "," +
                bprecords.KEY_item_date + "," +
                bprecords.KEY_item_comments +
                " FROM " + bprecords.TABLE
                + " WHERE " +
                bprecords.KEY_item_ID+ "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        bprecords travel_item = new bprecords();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                travel_item.item_ID =cursor.getInt(cursor.getColumnIndex(bprecords.KEY_item_ID));
                travel_item.item_name =cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_name));
                travel_item.item_status  =cursor.getInt(cursor.getColumnIndex(bprecords.KEY_item_status));
                travel_item.item_date =cursor.getInt(cursor.getColumnIndex(bprecords.KEY_item_date));
                travel_item.item_comments =cursor.getString(cursor.getColumnIndex(bprecords.KEY_item_comments));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return travel_item;
    }

}

