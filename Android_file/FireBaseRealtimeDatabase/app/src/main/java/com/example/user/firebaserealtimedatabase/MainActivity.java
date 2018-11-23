package com.example.user.firebaserealtimedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.firebaserealtimedatabase.adapter.ArtistList;
import com.example.user.firebaserealtimedatabase.beans.Artists;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String ARTIST_NAME="artistname";
    public static final String ARTIST_ID="artistid";
    EditText editTextName;
    Spinner spinnerType;
    Button btn_add;
    DatabaseReference databaseReference;
    ListView listViewArtists;
    List <Artists>  artistsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference= FirebaseDatabase.getInstance().getReference("artist");

        editTextName=findViewById(R.id.et_artists_name);
        spinnerType=findViewById(R.id.sp_artists);
        listViewArtists=findViewById(R.id.listview);

        artistsList=new ArrayList<>();
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtstis();
            }
        });
        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artists artists=artistsList.get(position);
                Intent intent=new Intent(getApplicationContext(),AddTrackActivity.class);
                intent.putExtra(ARTIST_ID,artists.getArtists_id());
                intent.putExtra(ARTIST_NAME,artists.getArtists_name());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistsList.clear();

                for(DataSnapshot dataSnapshots:dataSnapshot.getChildren()){
                    Artists artists=dataSnapshots.getValue(Artists.class);
                    artistsList.add(artists);

                }
                ArtistList adapter=new ArtistList(MainActivity.this,artistsList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addArtstis(){
        String name=editTextName.getText().toString().trim();
        String type=spinnerType.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name)){   /*  !<相反     isEmpty(空)*/
           String id=databaseReference.push().getKey();
           Artists artists=new Artists(id,name,type);
           databaseReference.child(id).setValue(artists);


        }else {
            Toast.makeText(this,"請輸入Name",Toast.LENGTH_LONG).show();

        }

    }


}
