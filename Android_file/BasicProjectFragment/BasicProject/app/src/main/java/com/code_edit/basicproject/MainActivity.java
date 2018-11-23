package com.code_edit.basicproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.code_edit.basicproject.adapter.CardItemAdapter;
import com.code_edit.basicproject.dialog.CustomerDialog;

public class MainActivity extends AppCompatActivity {
    private Toolbar MyToolbar;
    ListView listview;
    ViewFlipper vfp;
    Dialog mydialog;
    CustomerDialog cd;
    LinearLayout lay_acc,lay_page,lay_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyToolbar=findViewById(R.id.mytoolbar);//fbi
        setSupportActionBar(MyToolbar);
        setTitle("專案製作教學");
        listview=findViewById(R.id.listview);
        CardItemAdapter adapter=new CardItemAdapter(this);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),CardItemActivity.class);
                intent.putExtra("Position",position);
                startActivity(intent);
            }
        });
        vfp=findViewById(R.id.vf);
        vfp.startFlipping();
        vfp.setFlipInterval(3000);
        //customer dialog

        mydialog=new Dialog(this);
        mydialog.setContentView(R.layout.customer_dialog);


    }


    public void dialog_acc(View view){
        lay_acc=mydialog.findViewById(R.id.lay_access);
        startActivity(new Intent(MainActivity.this,ChartActivity.class));
        mydialog.show();
    }


    public void dialog_page(View view){
        lay_page=mydialog.findViewById(R.id.lay_page);
        startActivity(new Intent(MainActivity.this,ChartActivity.class));
        mydialog.show();
        cd.dismiss();
    }

    public void dialog_con(View view){
        lay_con=mydialog.findViewById(R.id.lay_context);
        startActivity(new Intent(MainActivity.this,ChartActivity.class));
        mydialog.show();
        cd.dismiss();
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
            dialog();
        }
        return false;
    }

    private void dialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(" 離開視窗 ")
                .setIcon(R.drawable.icons8)
                .setMessage(" 你確定要離開這個APP嗎?")
                .setPositiveButton(" 確定 ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        }).setNegativeButton(" 取消 ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
       switch(id){
           case R.id.action_about:
              cd=new CustomerDialog(MainActivity.this);
               //cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               cd.setCancelable(true);

               cd.show();
               break;

       }

        return super.onOptionsItemSelected(item);
    }
}
