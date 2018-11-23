package com.example.user.firebaserealtimedatabase.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.firebaserealtimedatabase.R;

import com.example.user.firebaserealtimedatabase.beans.Track;

import java.util.List;

public class TrackList extends ArrayAdapter{
    private Activity context;
    private List<Track> trackList;

    public TrackList(Activity context, List<Track> trackList) {
        super(context,R.layout.item_list_track,trackList);
        this.context=context;
        this.trackList=trackList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.item_list,null,true);

        Track track=trackList.get(position);

        TextView textViewName=listViewItem.findViewById(R.id.textView_name);
        TextView textViewType=listViewItem.findViewById(R.id.textView_type);

        textViewName.setText(track.getTrackName());
        textViewType.setText(String.valueOf(track.getTrackRating()));

        return listViewItem;
    }
}
