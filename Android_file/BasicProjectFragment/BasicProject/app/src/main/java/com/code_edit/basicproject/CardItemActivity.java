package com.code_edit.basicproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_edit.basicproject.adapter.CardItemAdapter;

public class CardItemActivity extends AppCompatActivity {
    int pos=0;  //position
    private Toolbar MyToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carditem);
        MyToolbar=findViewById(R.id.mytoolbar);//fbi
        setSupportActionBar(MyToolbar);
        setTitle("各類新聞");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intet=getIntent();
        pos=intet.getExtras().getInt("Position");

        final CardItemAdapter adapter=new CardItemAdapter(this);
        final ImageView img=findViewById(R.id.imageview_item);
        final TextView title=findViewById(R.id.textView_item);
        final TextView context=findViewById(R.id.textView2_item);

        img.setImageResource(adapter.img[pos]);  //pos=0
        title.setText(adapter.title[pos]); //pos=0
        context.setText(adapter.content[pos]); //pos=0

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
