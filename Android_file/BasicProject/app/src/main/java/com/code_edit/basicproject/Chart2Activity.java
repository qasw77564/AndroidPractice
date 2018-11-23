package com.code_edit.basicproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Chart2Activity extends AppCompatActivity {


    String day[]={"Jan","Feb","Mar","Apr","May","Jun"};
    float sun[]={10.4f,20.4f,30.4f,40.5f,50.6f,60.7f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart2);

    }
    private void setupChart2() {
        List<PieEntry> pieEntry=new ArrayList<>();
        for(int i=0;i<sun.length;i++){
            pieEntry.add(new PieEntry(sun[i],day[i]));

        }
        PieDataSet dataSet=new PieDataSet(pieEntry,"hahah");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataSet);
        PieChart chart=findViewById(R.id.chart2);
        chart.setData(data);
        chart.animateX(2000);
        chart.invalidate();
    }





}

