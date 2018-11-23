package tw.com.lccnet.app.projectapplication;

import android.content.ClipData;
import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    private  String [] list_Title;
    private  String [] list_Desc;
    private int[] images={R.drawable.a2,R.drawable.a1,R.drawable.a2,R.drawable.a1,R.drawable.a1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
        listview= (ListView) findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,PageActivity.class);
                intent.putExtra("ApiName",listview.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });

        list_Title=getResources().getStringArray(R.array.ser_Title);
        list_Desc=getResources().getStringArray(R.array.ser_Desc);
        MyAdapter adapter=new MyAdapter(this,images,list_Title,list_Desc);
        listview.setAdapter(adapter);

    }
    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        int[] images;
        String[] mytitle;
        String[] myDesc;

        MyAdapter(Context context, int[] images, String[] mytitle, String[] myDesc) {
            super(context,R.layout.listviewitem,R.id.txtTitle,mytitle);
            this.context=context;
            this.images=images;
            this.mytitle=mytitle;
            this.myDesc=myDesc;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.listviewitem,parent,false);

            ImageView image= (ImageView) row.findViewById(R.id.image_mg);

            TextView myTitle= (TextView) row.findViewById(R.id.txtTitle);

            TextView myDesc= (TextView) row.findViewById(R.id.txtDesc);
            image.setImageResource(images[position]);
            myTitle.setText(list_Title[position]);
            myDesc.setText(list_Desc[position]);
            return row;
        }
    }

    public void initActivity(){
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//預設
        getSupportActionBar().setDisplayShowTitleEnabled(false);//取消預設

        TextView mtitle= (TextView) toolbar.findViewById(R.id.textber);
        mtitle.setText("Activity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
