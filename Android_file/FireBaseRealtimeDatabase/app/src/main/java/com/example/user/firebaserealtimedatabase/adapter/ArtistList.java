package com.example.user.firebaserealtimedatabase.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.firebaserealtimedatabase.R;
import com.example.user.firebaserealtimedatabase.beans.Artists;

import java.util.List;

public class ArtistList extends ArrayAdapter {
    private Activity context;
    private List<Artists> artists;

    public ArtistList(Activity context, List<Artists> artistLists) {
        super(context, R.layout.item_list, artistLists);
        this.context = context;
        this.artists=artistLists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.item_list,null,true);

        Artists artist=artists.get(position);

        TextView textViewName=listViewItem.findViewById(R.id.textView_name);
        TextView textViewType=listViewItem.findViewById(R.id.textView_type);

        textViewName.setText(artist.getArtists_name());
        textViewType.setText(artist.getArtists_type());

        return listViewItem;
    }
}
