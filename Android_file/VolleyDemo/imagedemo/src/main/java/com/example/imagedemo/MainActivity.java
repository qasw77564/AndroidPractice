package com.example.imagedemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    Button  btn_getimage;
    ImageView action_image;
    String server_url="https://i.pinimg.com/736x/06/46/91/064691acca105f922b6155e530e2b7ee--korean-ulzzang-ulzzang-girl.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getimage=findViewById(R.id.btn_getimage);
        action_image=findViewById(R.id.action_image);
        btn_getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest=new ImageRequest(server_url,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                action_image.setImageBitmap(response);
                            }
                        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleTon.getmInstance(MainActivity.this).addToRequestQue(imageRequest);
            }
        });

    }
}
