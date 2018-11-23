package tw.com.lccnet.app.customeralertdialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import static tw.com.lccnet.app.customeralertdialog.R.id.btntolog;

public class MainActivity extends AppCompatActivity {
    private Button cusBtn;
    private View viewCustomer;
    private Context mContext;
    private AlertDialog alert=null;
    private AlertDialog.Builder builder=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cusBtn= (Button) findViewById(btntolog);
        mContext=MainActivity.this;
        builder=new AlertDialog.Builder(mContext);

        LayoutInflater inflater=MainActivity.this.getLayoutInflater();
        viewCustomer=inflater.inflate(R.layout.custom_item,null,false);
        builder.setView(viewCustomer);
        builder.setCancelable(false);
        alert=builder.create();

        viewCustomer.findViewById(R.id.btnclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        viewCustomer.findViewById(R.id.btnxx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("http://www.yahoo.com.tw");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                alert.dismiss();
            }
        });
        viewCustomer.findViewById(R.id.btnxxx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });

    cusBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alert.show();
        }
    });

    }
}
