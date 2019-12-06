package com.example.hotelApp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesUtil {
    private static Context context;
    public SharedPreferencesUtil(Context context) {
        this.context = context;
    }

    public static void createStringPreference(String key, String value){
        SharedPreferences.Editor editor = context.getSharedPreferences(key, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringPreference (String key){
        SharedPreferences prefs = context.getSharedPreferences(key, MODE_PRIVATE);
        String name = prefs.getString( key, null);
        return name;
    }
}
