package tw.com.lccnet.otherelement;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    int total=0;
    Button b_on,b_off,b_dis,b_list;
    BluetoothAdapter bluetoothAdapter;
    ListView list;
    private static final int REQUEST_ENABLED=0;
    private static final int REQUEST_DISCOVERABLE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar=findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                total+=rating;
                Toast.makeText(getApplicationContext(),"Value is:"+total,Toast.LENGTH_LONG).show();
            }
        });

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        b_on=findViewById(R.id.b_on);
        b_off=findViewById(R.id.b_off);
        b_dis=findViewById(R.id.b_dis);
        b_list=findViewById(R.id.b_list);
        list=findViewById(R.id.listview);

        if(bluetoothAdapter ==null){
            Toast.makeText(getApplicationContext(),"藍芽裝置未啟動?",Toast.LENGTH_LONG).show();
            finish();
        }

        b_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent,REQUEST_ENABLED);
            }
        });

        b_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
            }
        });

        b_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothAdapter.isDiscovering()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVERABLE);
                }
            }
        });

        b_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> pairedDevices=bluetoothAdapter.getBondedDevices();
                ArrayList<String> device=new ArrayList<>();

                for(BluetoothDevice bt:pairedDevices){
                    device.add(bt.getName());
                }

                ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,device);
                list.setAdapter(arrayAdapter);
            }
        });

    }
}
