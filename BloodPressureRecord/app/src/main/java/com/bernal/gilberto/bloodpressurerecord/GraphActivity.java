package com.bernal.gilberto.bloodpressurerecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;


public class GraphActivity extends AppCompatActivity {

    private BcrCursorAdapter ca;
    private BcrDatabaseHelper databaseHelper;
    //private static final int ENTER_DATA_REQUEST_CODE = 1;
    LineGraphSeries<DataPoint> series;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lineChart = (LineChart) findViewById(R.id.graph);
        databaseHelper = new BcrDatabaseHelper(this);
        ArrayList <Entry> graphdatasys = new ArrayList<>();
        ArrayList <Entry> graphdatadiast = new ArrayList<>();
        ArrayList <String> graphdatax = new ArrayList<>();

       // ca = new BcrCursorAdapter (GraphActivity.this, databaseHelper.getAllData());
        Cursor ca = databaseHelper.getAllData();

        int x = 0;
        int xg = 0;

        while(ca.moveToNext())
        {
            String sys,dias;
            sys = ca.getString(ca.getColumnIndex("bcr_systolic"));
            int sys1=Integer.parseInt(sys);
            dias = ca.getString(ca.getColumnIndex("bcr_diastolic"));
            int dias1=Integer.parseInt(dias);
            graphdatasys.add(new Entry(sys1,x));
            graphdatadiast.add(new Entry(dias1,x));
            graphdatax.add(x, String.valueOf(x));
            x=x+1;
        }

        ArrayList <ILineDataSet> linedataSets = new ArrayList<>();
        LineDataSet lineDataSet1 =  new LineDataSet(graphdatasys,"Systolic");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 =  new LineDataSet(graphdatadiast,"Diastolic");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        linedataSets.add(lineDataSet1);
        linedataSets.add(lineDataSet2);

        lineChart.setData(new LineData(graphdatax,linedataSets));
        lineChart.setVisibleXRangeMaximum(65f);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
