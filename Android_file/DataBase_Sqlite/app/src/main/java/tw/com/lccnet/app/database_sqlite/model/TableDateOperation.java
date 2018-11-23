package tw.com.lccnet.app.database_sqlite.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Student on 2017/9/17.
 */

public class TableDateOperation extends SQLiteOpenHelper {
    public static final int DATEBASE_VERSION=1;
    public String CREATE_QUERY="CREATE TABLE "+ TableDate.TabInfo.TABLE_NAME+"( "+ TableDate.TabInfo.USER_NAME+" TEXT" + TableDate.TabInfo.USER_PASS+" TEXT )";
    public TableDateOperation(Context context) {
        super(context, TableDate.TabInfo.DATEBASE_NAME, null, DATEBASE_VERSION);
        Log.d("DatebaseOperation","datebase create success");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.d("DatebaseOperation","table create success");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(TableDateOperation dop,String name,String pass){
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableDate.TabInfo.USER_NAME,name);
        cv.put(TableDate.TabInfo.USER_PASS,pass);
        long k=SQ.insert(TableDate.TabInfo.TABLE_NAME,null,cv);
        Log.d("DatebaseOperation","table create success"+k+"筆");
    }
    public Cursor getInformation(TableDateOperation dop){
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String[] coloumns={TableDate.TabInfo.USER_NAME, TableDate.TabInfo.USER_PASS};
        Cursor CR=SQ.query(TableDate.TabInfo.TABLE_NAME,coloumns,null,null,null,null,null);
        return CR;
    }
}
