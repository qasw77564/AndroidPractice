package com.example.user.firebaserealtimedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.firebaserealtimedatabase.adapter.ArtistList;
import com.example.user.firebaserealtimedatabase.adapter.TrackList;
import com.example.user.firebaserealtimedatabase.beans.Artists;
import com.example.user.firebaserealtimedatabase.beans.Track;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddTrackActivity extends AppCompatActivity {
    TextView textViewArtistName;
    EditText editTextTrackName;
    SeekBar seekBarRating;
    Button buttonAddtrack;

    ListView listViewTrack;


    List<Track> artistsList_track;

    DatabaseReference databaseReference_track;/*連接資料庫*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrack);
        textViewArtistName=findViewById(R.id.textViewArtistName);
        editTextTrackName=findViewById(R.id.et_artists_track_name);
        seekBarRating=findViewById(R.id.seekBarRating);
        listViewTrack=findViewById(R.id.listview_track);
        buttonAddtrack=findViewById(R.id.btn_add_track);


        artistsList_track=new ArrayList<>();


        Intent intent=getIntent();
        String id=intent.getStringExtra(MainActivity.ARTIST_ID);
        String name=intent.getStringExtra(MainActivity.ARTIST_NAME);
        textViewArtistName.setText(name);
                                                                                        /*↓子類別裡有父類ID*/
        databaseReference_track= FirebaseDatabase.getInstance().getReference("tracks").child(id);

        buttonAddtrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTracks();
            }
        });




    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference_track.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistsList_track.clear();
                for(DataSnapshot dataSnapshotd:dataSnapshot.getChildren()){
                    Track track=dataSnapshotd.getValue(Track.class);
                    artistsList_track.add(track);

                }
                TrackList adapter=new TrackList(AddTrackActivity.this,artistsList_track);
                listViewTrack.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    public void saveTracks(){
        String trackName=editTextTrackName.getText().toString().trim();
        int rating=seekBarRating.getProgress();

        if(!TextUtils.isEmpty(trackName)){
            String id=databaseReference_track.push().getKey();
            Track track=new Track(id,trackName,rating);


            databaseReference_track.child(id).setValue(track);
        }else{
            Toast.makeText(this,"請輸入名稱",Toast.LENGTH_LONG).show();
        }

    }


}
