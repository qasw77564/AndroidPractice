package tw.com.lccnet.sqlitedemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import tw.com.lccnet.sqlitedemo.config.TableData;

/**
 * Created by Student on 2018/3/5.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public String CREATE_TABLE="create table "+ TableData.TableInfo.TABLE_NAME+"("+
                                                TableData.TableInfo.USER_NAME+" text,"+
                                                TableData.TableInfo.USER_PASS+" text);";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, TableData.TableInfo.VERSION);
        Log.i("DATABASE CREATE","databse create .......");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i("TABLE CREATE","table create .......");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    //Register  註冊新使用者時，調用此方法
    public void putInformation(DatabaseOperations dop,String name,String pass){
        SQLiteDatabase sq=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME,name);
        cv.put(TableData.TableInfo.USER_PASS,pass);
        long k=sq.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.i("new  user","create :"+k+" user  success....");
    }


    public Cursor getInformatio0n(DatabaseOperations dop){
        SQLiteDatabase sq=dop.getReadableDatabase();
        String[] coioumns={TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor CR=sq.query(TableData.TableInfo.TABLE_NAME,coioumns,null,null,null,null,null);
        return CR;
    }

    public Cursor getUserPass(DatabaseOperations dop,String user){
        SQLiteDatabase sq=dop.getReadableDatabase();
        String selection= TableData.TableInfo.USER_NAME+" LIKE?";
       String coloumns[] ={TableData.TableInfo.USER_PASS};
        String args[]={user};
        Cursor CR=sq.query(TableData.TableInfo.TABLE_NAME,coloumns,selection,args,null,null,null);

        return CR;
    }
    public void deleteUser(DatabaseOperations dop,String user,String pass){
        String selection= TableData.TableInfo.USER_NAME+" Like ? AND "+ TableData.TableInfo.USER_PASS+" Like ? ";
        String coloumns[]={TableData.TableInfo.USER_PASS};
        String args[]={user,pass};
        SQLiteDatabase sq=dop.getWritableDatabase();
        sq.delete(TableData.TableInfo.TABLE_NAME,selection,args);
    }

}
