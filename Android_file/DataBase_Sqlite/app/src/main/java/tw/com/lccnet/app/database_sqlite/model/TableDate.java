package tw.com.lccnet.app.database_sqlite.model;

import android.provider.BaseColumns;

/**
 * Created by Student on 2017/9/17.
 */

public class TableDate {
    public TableDate() {
    }

    public static abstract class TabInfo implements BaseColumns{
        public static final String USER_NAME="user_name";
        public static final String USER_PASS="user_pass";
        public static final String DATEBASE_NAME="user_info";
        public static final String TABLE_NAME="reg_info";
    }
}
