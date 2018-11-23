package com.wthe.c_toolbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wthe.c_toolbar.R;

/**
 * Created by wthe on 2018/2/21.
 */

public class CardItemAdapter extends BaseAdapter {
    Context context;
    public String[] title;
    public String[] data;//={"data1","data2","data3","data4","data5","data6","data7","data8","data9","data10"};
    public int[] img={R.drawable.img04,R.drawable.img06,R.drawable.img04,R.drawable.img06,R.drawable.img04,
            R.drawable.img06,R.drawable.img06,R.drawable.img06,R.drawable.img06,R.drawable.img04};

    public CardItemAdapter(Context context) {

        this.context=context;
        title=context.getResources().getStringArray(R.array.list_tt);
        data=context.getResources().getStringArray(R.array.list_desc);

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
        if(convertView== null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.my_list,null);
        }

        TextView titles=convertView.findViewById(R.id.title_item);
        TextView datas=convertView.findViewById(R.id.data_item);
        ImageView imgs=convertView.findViewById(R.id.imageView);

        titles.setText(title[position]);
        datas.setText(data[position]);
        imgs.setImageResource(img[position]);
        return convertView;
    }
}
