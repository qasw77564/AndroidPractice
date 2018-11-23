package com.code_edit.basicproject;

import android.graphics.Color;
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
    String month[]={"Jan","Feb","Mar","Apr","May","Jun"};
    float rain[]={98.8f,123.8f,161.8f,24.2f,52f,58.2f};

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

        PieDataSet dataSet=new PieDataSet(pieEntry,"數據圖表");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataSet);

        PieChart chart=findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(2000);
        chart.invalidate();
    }
}
