package com.wthe.c_toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wthe.c_toolbar.adapter.CardItemAdapter;

public class CardItemActivity extends AppCompatActivity {
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carditem);

        Intent intents=getIntent();
        pos=intents.getExtras().getInt("Position");

        final CardItemAdapter adapter=new CardItemAdapter(this);
        final ImageView img_c=findViewById(R.id.imag_c);
        final TextView title_c=findViewById(R.id.tv_c1);
        final TextView data_c=findViewById(R.id.tv_c2);

        img_c.setImageResource(adapter.img[pos]);
        title_c.setText(adapter.title[pos]);
        data_c.setText(adapter.data[pos]);

        Button bt=findViewById(R.id.button_c);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position;
                //預防點擊最後一個選項後照成的BUG
                if(pos>=adapter.title.length-1){
                    position=0;
                }else {position=pos+1;}

                img_c.setImageResource(adapter.img[position]);
                title_c.setText(adapter.title[position]);
                data_c.setText(adapter.data[position]);

                if(!(position>=adapter.getCount()-1)){
                    pos+=1;
                }else {
                    pos=-1;
                }
            }
        });

    }
}
