package tw.com.lccnet.app.onback;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4;
    private Context mContext;
    private boolean[] chekItem;
    private AlertDialog alert=null;
    private AlertDialog.Builder builder=null;
    private String[] data=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        init();
    }
    private void init(){
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.btn1:
            alert=null;
            builder=new AlertDialog.Builder(mContext);
            alert=builder.setIcon(R.drawable.ic_launcher)
                    .setTitle("訊息")
                    .setMessage("一般警告訊息")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("一般", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            alert.show();
            break;
        case R.id.btn2:
            data=getResources().getStringArray(R.array.city);
            alert=null;
            builder=new AlertDialog.Builder(mContext);
            alert=builder.setIcon(R.drawable.ic_launcher)
                    .setTitle("提示")
                    .setItems(data, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            alert.show();
            break;
        case R.id.btn3:
            data=getResources().getStringArray(R.array.city);
            alert=null;
            builder=new AlertDialog.Builder(mContext);
            alert=builder.setIcon(R.drawable.ic_launcher)
                    .setTitle("提示")
                    .setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            alert.show();
            break;
        case R.id.btn4:
            data=getResources().getStringArray(R.array.city);
            chekItem=new boolean[]{false,false,false,false,false};
            alert=null;
            builder=new AlertDialog.Builder(mContext);
            alert=builder.setIcon(R.drawable.ic_launcher)
                    .setTitle("提示")
                    .setMultiChoiceItems(data, chekItem, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                            chekItem[i]=isChecked;
                        }
                    })
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        String result="";
                            for(int i=0;i<chekItem.length;i++){
                                if(chekItem[i]){
                                    result+=data[i]+"";
                                }
                            }
                        }
                    }).create();
            alert.show();

            break;

        }
    }
}
