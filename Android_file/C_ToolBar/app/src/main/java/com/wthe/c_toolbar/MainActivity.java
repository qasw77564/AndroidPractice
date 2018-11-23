package com.wthe.c_toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wthe.c_toolbar.adapter.CardItemAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.mytool);
        listView=findViewById(R.id.listview);

        listView.setAdapter(new CardItemAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),CardItemActivity.class);
                intent.putExtra("Position",position);
                startActivity(intent);
            }
        });
    }
}
