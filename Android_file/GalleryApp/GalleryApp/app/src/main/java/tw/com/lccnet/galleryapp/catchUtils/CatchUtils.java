package tw.com.lccnet.galleryapp.catchUtils;

import android.content.Context;
import android.content.SharedPreferences;

import tw.com.lccnet.galleryapp.WelcomeActivity;

public class CatchUtils {


    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("gallery", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static boolean setBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("gallery", Context.MODE_PRIVATE);
        return sp.edit().putBoolean(key, true).commit();
    }
}
