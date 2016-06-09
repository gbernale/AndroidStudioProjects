package com.smile.gilberto.tabdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smile.gilberto.tabdemo.CreateDBHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Registered User on 5/29/16.
 */
public class TravelRepo {
    private CreateDBHelper dbHelper;

    public TravelRepo(Context context) {
        dbHelper = new CreateDBHelper(context);
    }

    public int insert(Travel_Items travel_item ) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Travel_Items.KEY_item_name, travel_item.item_name);
        values.put(Travel_Items.KEY_item_status,travel_item.item_status);
        values.put(Travel_Items.KEY_item_date, travel_item.item_date);
        values.put(Travel_Items.KEY_item_comments, travel_item.item_comments);

        // Inserting Row
        long travel_item_Id = db.insert(Travel_Items.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) travel_item_Id;
    }

    public void delete(int travel_item_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Travel_Items.TABLE, Travel_Items.KEY_item_ID + "= ?", new String[] { String.valueOf(travel_item_Id) });
        db.close(); // Closing database connection
    }

    public void update(Travel_Items travel_item) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Travel_Items.KEY_item_name, travel_item.item_name);
        values.put(Travel_Items.KEY_item_status,travel_item.item_status);
        values.put(Travel_Items.KEY_item_date, travel_item.item_date);
        values.put(Travel_Items.KEY_item_comments, travel_item.item_comments);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Travel_Items.TABLE, values, Travel_Items.KEY_item_ID + "= ?", new String[] { String.valueOf(travel_item.item_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getTravelItemList() {
        //Open connection to read only
        //Travel_Items travel_item = new Travel_Items();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Travel_Items.KEY_item_ID + "," +
                Travel_Items.KEY_item_name + "," +
                Travel_Items.KEY_item_status + "," +
                Travel_Items.KEY_item_date + "," +
                Travel_Items.KEY_item_comments +
                " FROM " + Travel_Items.TABLE;

        //Travel_Items   travel_item = new Travel_Items();
        ArrayList<HashMap<String, String>> travelitemList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> travel_item = new HashMap<String, String>();
                travel_item.put("item_id", cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_ID)));
                travel_item.put("item_name", cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_name)));
                travel_item.put("item_Status", cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_status)));
                travel_item.put("item_date", cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_date)));
                travel_item.put("item_comments", cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_comments)));
                travelitemList.add(travel_item);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return travelitemList;
    }

    public Travel_Items getTravelistById(int Id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Travel_Items.KEY_item_ID + "," +
                Travel_Items.KEY_item_name + "," +
                Travel_Items.KEY_item_status + "," +
                Travel_Items.KEY_item_date + "," +
                Travel_Items.KEY_item_comments +
                " FROM " + Travel_Items.TABLE
                + " WHERE " +
                Travel_Items.KEY_item_ID+ "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Travel_Items travel_item = new Travel_Items();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                travel_item.item_ID =cursor.getInt(cursor.getColumnIndex(Travel_Items.KEY_item_ID));
                travel_item.item_name =cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_name));
                travel_item.item_status  =cursor.getInt(cursor.getColumnIndex(Travel_Items.KEY_item_status));
                travel_item.item_date =cursor.getInt(cursor.getColumnIndex(Travel_Items.KEY_item_date));
                travel_item.item_comments =cursor.getString(cursor.getColumnIndex(Travel_Items.KEY_item_comments));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return travel_item;
    }

}
