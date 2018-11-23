package tw.com.lccnet.sqlitedemo.config;

import android.provider.BaseColumns;

/**
 * Created by Student on 2018/3/5.
 */

public class TableData {

    public TableData() {
    }

    public static abstract class TableInfo implements BaseColumns{
        //建立table 欄位名稱,table 名稱 資料庫名稱
        public static final String USER_NAME="user_name";  //常數
        public static final String USER_PASS="user_pass";
        public static final String DATABASE_NAME="user_info";
        public static final String TABLE_NAME="reg_info";
        public static final int VERSION=1;

    }

}
