package com.code_edit.basicproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_edit.basicproject.R;

/**
 * Created by Student on 2018/2/21.
 */

public class CardItemAdapter extends BaseAdapter {
    Context context; //
    public String[] title;
   public String[] content;
    public int[] img={R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,R.drawable.icon5,R.drawable.icon6};

    public CardItemAdapter(Context context) {
        this.context = context;
        title=context.getResources().getStringArray(R.array.str_titlt);
        content=context.getResources().getStringArray(R.array.str_context);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //將整個card_item 導入
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.card_item,null);
        }

        ImageView imags=convertView.findViewById(R.id.img_item);
        TextView tile=convertView.findViewById(R.id.title_item);
        TextView context=convertView.findViewById(R.id.content_item);

        imags.setImageResource(img[position]);
        tile.setText(title[position]);
        context.setText(content[position]);
        return convertView;
    }
}
