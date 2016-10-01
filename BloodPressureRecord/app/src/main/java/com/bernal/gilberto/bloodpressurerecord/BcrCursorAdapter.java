package com.bernal.gilberto.bloodpressurerecord;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Registered User on 9/30/2016.
 */

public class BcrCursorAdapter extends CursorAdapter {
    public BcrCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
// when the view will be created for first time,
// we need to tell the adapters, how each item will look
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.single_row_item, parent, false);
        return retView;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
// here we are setting our data
// that means, take the data from the cursor and put it in views
        TextView textViewSystolic = (TextView) view.findViewById(R.id.tv_systolic);
        textViewSystolic.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
        TextView textViewDiastolic = (TextView) view.findViewById(R.id.tv_diastolic);
        textViewDiastolic.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
        TextView textViewPulse = (TextView) view.findViewById(R.id.tv_pulse);
        textViewPulse.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
        TextView textViewDdate = (TextView) view.findViewById(R.id.tv_date);
        textViewDdate.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(4))));
        TextView textViewComments = (TextView) view.findViewById(R.id.tv_comments);
        textViewComments.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(5))));
    }
}

