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

public class ChartActivity extends AppCompatActivity {
    String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    float rain[]={10.4f,20.4f,30.4f,40.5f,50.6f,60.7f,70.4f,80.5f,90.1f,100.6f,110.9f,120.9f};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        setupChart();

    }

    private void setupChart() {
        List<PieEntry> pieEntry=new ArrayList<>();
        for(int i=0;i<rain.length;i++){
            pieEntry.add(new PieEntry(rain[i],month[i]));

        }
        PieDataSet dataSet=new PieDataSet(pieEntry,"hahah");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataSet);
        PieChart chart=findViewById(R.id.chart);
        chart.setData(data);
        chart.animateX(2000);
        chart.invalidate();
    }
}
