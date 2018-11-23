package com.example.user.jsontest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.jsontest01.bean.DataInfo;
import com.example.user.jsontest01.bean.FileInfo;
import com.example.user.jsontest01.bean.Showjson01;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button json_btn1,json_btn2,json_btn3,json_btn4;
    TextView tv_title,tv_na,tv_tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                tv_title.setText("Java Object解析");
                jsonToJavaObjectByNative();
                break;

            case R.id.json_btn2:
                tv_title.setText("Java Array解析[Arr{Obj}]");
                jsonToJavaListBative();
                break;

            case R.id.json_btn3:
                tv_title.setText("Java 複雜解析{Obj{Obj[Arr{Obj}]}");
                jsonToJavaOfComplex();
                break;

            case R.id.json_btn4:
                tv_title.setText("Java特殊解析{Obj,list{Obj{Obj}}}");
                jsonToJavaOfSpecial();
                break;






        }
    }

    private void jsonToJavaOfSpecial() {
        FileInfo fileInfo=new FileInfo();
        List<FileInfo.FileBean> lists=new ArrayList<>();
        //1.創造json數據
        String json="{\n" +
                "    \"code\":0,\"list\":{\n" +
                "        \"0\":{\n" +
                "            \"aid\":\"606\",\n" +
                "            \"author\":\"chen\",\n" +
                "            \"coins\":350,\n" +
                "            \"copyright\":\"Copy\",\n" +
                "            \"create\":\"2018-04-13 21:34\"}\n" +
                "        ,\n" +
                "        \"1\":{\n" +
                "            \"aid\":\"404\",\n" +
                "            \"author\":\"hid\",\n" +
                "            \"coins\":300,\n" +
                "            \"copyright\":\"Copy\",\n" +
                "            \"create\":\"2018-03-13 21:34\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //2.解析數據
        //封裝
        try {

            JSONObject jsonObject= new JSONObject(json);

            //第一層解析
            int code=jsonObject.optInt("code");
            JSONObject list=jsonObject.optJSONObject("list");
            //第一層封裝
            fileInfo.setCode(code);
            fileInfo.setList(lists);
            //第二層解析
            for(int i=0;i<list.length();i++){
                JSONObject jsonObject1=list.optJSONObject(i+"");
                if(jsonObject1 != null) {
                    String aid = jsonObject1.optString("aid");
                    String author = jsonObject1.optString("author");
                    int coins = jsonObject1.optInt("coins");
                    String copyright = jsonObject1.optString("copyright");
                    String create = jsonObject1.optString("create");
                    //第二層封裝
                    FileInfo.FileBean fileBean=new FileInfo.FileBean();
                    fileBean.setAid(aid);
                    fileBean.setAuthor(author);
                    fileBean.setCoins(coins);
                    fileBean.setCopyright(copyright);
                    fileBean.setCreate(create);
                    //將資料輸入集合↓
                    lists.add(fileBean);//將資料輸入集合
                }


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(fileInfo.toString());
    }

    private void jsonToJavaOfComplex() {

        //1.創造json數據
        String json="{\"data\":{\"count\":5,\"item\":[{\"id\":45,\"title\":\"ha\"},{\"id\":46,\"title\":\"ah\"},{\"id\":47,\"title\":\"ma\"}]},\"rs_code\":\"1000\",\"rs_msg\":\"success\"}";
        //2.解析數據
        //封裝
        DataInfo dataInfo=new DataInfo();
        try {

            JSONObject jsonObject=new JSONObject(json);

            //第一層解析
            JSONObject data=jsonObject.optJSONObject("data");
            String rs_code=jsonObject.optString("rs_code");
            String rs_msg=jsonObject.optString("rs_msg");
            //第一層封裝
            dataInfo.setRs_code(rs_code);
            dataInfo.setRs_msg(rs_msg);
            DataInfo.DataBean dataBean=new DataInfo.DataBean();
            dataInfo.setData(dataBean);



            //第二層解析
            int count=data.optInt("count");
            JSONArray item=data.optJSONArray("item");
            //第二層封裝
            dataBean.setCount(count);
            List<DataInfo.DataBean.ItemBean> itemsBean=new ArrayList<>();
            dataBean.setItem(itemsBean);


            //第三層解析
            for(int i=0;i<item.length();i++){
                JSONObject obj=item.getJSONObject(i);

                if(obj !=null){
                    int id=obj.optInt("id");
                    String title=obj.optString("title");
                    //第三層封裝

                    DataInfo.DataBean.ItemBean bean=new DataInfo.DataBean.ItemBean();
                    bean.setId(id);
                    bean.setTitle(title);
                    //將資料輸入集合↓
                    itemsBean.add(bean);//將資料輸入集合

                }
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(dataInfo.toString());
    }

    private  void  jsonToJavaListBative(){
        Showjson01 s1=null;
        List<Showjson01> list=new ArrayList<>();
        //1.創造json數據
        String json="[{\"id\":1,\"name\":\"chen\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"},"+
                    "{\"id\":2,\"name\":\"dor\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"},"+
                    " {\"id\":3,\"name\":\"hay\",\"price\":300,\"path\":\"http://tw.yahoo.com.tw\"}]";
        //2.解析數據
        try {

            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);

                if(jsonObject != null){
                    int id=jsonObject.optInt("id");
                    String name=jsonObject.optString("name");
                    int price =jsonObject.optInt("price");
                    String path=jsonObject.optString("path");
                    s1=new Showjson01(id,name,price,path);
                    list.add(s1);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(list.toString());
    }

    private void jsonToJavaObjectByNative() {
        //1.創造ason數據
        String json="{\"id\":2,\"name\":\"high\",\"price\":12.3,\"path\":\"http://www.yahoo.com.tw\"}";
        Showjson01 s1=null;
        //2.解析數據
        try {
            JSONObject jsonObject=new JSONObject(json);
            int id=jsonObject.getInt("id");
            int id1=jsonObject.optInt("id");
            String name=jsonObject.optString("name");
            double price=jsonObject.optInt("price");
            String path=jsonObject.optString("path");
            s1=new Showjson01(id,name,price,path);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //3.顯示數據
        tv_na.setText(json);
        tv_tr.setText(s1.toString());
    }
}
