package com.smile.gilberto.travelassistdb;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Registered User on 5/9/16.
 */
public class Travel_Items {
    // Labels table name
    public static final String TABLE = "Travel_Items";

    // Labels Table Columns names
    public static final String KEY_item_ID = "item_id";
    public static final String KEY_item_name = "item_name";
    public static final String KEY_item_status = "item_status";
    public static final String KEY_item_date = "item_date";
    public static final String KEY_item_comments = "item_comments";

    // property help us to keep data
    public int item_ID;
    public String item_name;
    public Integer item_status;
    public Integer item_date;
    public String item_comments;
}