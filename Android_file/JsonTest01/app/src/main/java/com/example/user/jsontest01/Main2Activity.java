package com.example.user.jsontest01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.jsontest01.bean.DataBaseConnctionJson;
import com.example.user.jsontest01.bean.FileInfo;
import com.example.user.jsontest01.bean.Showjson01;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button json_btn1,json_btn2,json_btn3,json_btn4;
    TextView tv_title,tv_na,tv_tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        initLister();


    }

    private void initLister() {
        json_btn1.setOnClickListener(this);
        json_btn2.setOnClickListener(this);
        json_btn3.setOnClickListener(this);
        json_btn4.setOnClickListener(this);


    }

    private void init() {
        tv_title=findViewById(R.id.title1);
        json_btn1=findViewById(R.id.json_btn1);
        json_btn2=findViewById(R.id.json_btn2);
        json_btn3=findViewById(R.id.json_btn3);
        json_btn4=findViewById(R.id.json_btn4);

        tv_na=findViewById(R.id.tv_native);
        tv_tr=findViewById(R.id.tv_try);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.json_btn1:
                tv_title.setText("Gson Object解析");
                jsonToJavaObjectByGson();
                break;

            case R.id.json_btn2:
                tv_title.setText("Gson Array解析[Arr{Obj}]");
                jsonToJavaListByGson();
                break;

            case R.id.json_btn3:
                tv_title.setText("Gson 複雜解析{Obj{Obj[Arr{Obj}]}");
                javaToJsonObjectByGson();
                break;

            case R.id.json_btn4:
                tv_title.setText("Gson 特殊解析{Obj,list{Obj{Obj}}}");
                javaToJsonArrayListByGson();
                break;

            /*
             * 1.導入gson jar
             * 2.建立gson對象
             * 3.透過formjson(json,java反射)方法返回Java對象
             *
             * ps:json項目名(屬性跟檔案名)要跟Gson項目名要一樣,一定要使用Java Bean*/





        }
    }

    private void javaToJsonArrayListByGson() {
        //1.取得或建立java對象
        /*如果是Array資料[{}] 先把Array陣列集合List入Java Bean , 需要多少的在new出來 , 然後add Array進陣列*/
     /*   List<Showjson01> shops=new ArrayList<>();
        Showjson01 s01=new Showjson01(1,"單車",7000,"桃園市");
        Showjson01 s02=new Showjson01(2,"摩托車",50000,"桃園市");
        Showjson01 s03=new Showjson01(3,"轎車",600000,"桃園市");
        shops.add(s01);
        shops.add(s02);
        shops.add(s03);*/
        //2.生成json數據
        /*把Gson new進來*/
     /*   Gson gson=new Gson();
        /*調用toJson方法,返回String*/
     /*   String s=gson.toJson(shops);
        //3.展示數據
        tv_na.setText(shops.toString());
        tv_tr.setText(s);
     */
        List<DataBaseConnctionJson> dataBaseConnctionJsons=new ArrayList<>();
        DataBaseConnctionJson d01=new DataBaseConnctionJson();
        DataBaseConnctionJson d02=new DataBaseConnctionJson();
        DataBaseConnctionJson d03=new DataBaseConnctionJson();
        DataBaseConnctionJson d04=new DataBaseConnctionJson();
        dataBaseConnctionJsons.add(d01);
        dataBaseConnctionJsons.add(d02);
        dataBaseConnctionJsons.add(d03);
        dataBaseConnctionJsons.add(d04);
        Gson gson1=new Gson();
        String d=gson1.toJson(dataBaseConnctionJsons);
        tv_na.setText(dataBaseConnctionJsons.toString());
        tv_tr.setText(d);

    }

    private void javaToJsonObjectByGson() {
            /*
              將java對象轉成json 使用toJson(Object j)方法
              建立gson對象(Java Bean)
              調用toJson方法,返回String
            */
        //1.取得或建立java對象
        Showjson01 shops=new Showjson01(1,"單車",7000,"桃園市");
        //2.生成json數據
        /*把Gson new進來*/
        Gson gson=new Gson();
        /* gson.toJson(shops); 要返回String  */
        String s=gson.toJson(shops);
        //3.展示數據
        //倒過來
        tv_na.setText(shops.toString());
        tv_tr.setText(s);
    }

    private void jsonToJavaListByGson() {
            /*
            將json格式的字串[] 轉成 Java 對象 List
            */
        //1.創造json數據
        String json="[{\"id\":1,\"name\":\"chen\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"},"+
                "{\"id\":2,\"name\":\"dor\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"},"+
                " {\"id\":3,\"name\":\"hay\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"}]";

        //2.解析數據
        Gson gson =new Gson();
        //fromJson導String  T(代表Object)  Gson解析List↓(透過Token去解析Java Bean)
        //使用List就返回List給他  gson.fromJson(json,new TypeToken<List<Showjson01>>(){}.getType());
        List<Showjson01> shops= gson.fromJson(json,new TypeToken<List<Showjson01>>(){}.getType());

        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(shops.toString());
    }

    private void jsonToJavaObjectByGson() {
        //1.創造json數據
        String json="{\"id\":2,\"name\":\"high\",\"price\":12.3,\"path\":\"http://www.yahoo.com.tw\"}";
        //2.解析數據
        Gson gson=new Gson();
        Showjson01 sh01= gson.fromJson(json,Showjson01.class);
        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(sh01.toString());
    }


}
