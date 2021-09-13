package com.sumit.unit3asyncapiinfragment;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private  static  final  String KEY = "evaluation.code";
    public static SharedPreferences getSharedPreference(Context context){
        return context.getSharedPreferences(KEY,Context.MODE_PRIVATE);
    }

    public static  void writeIntSharedPreference(Context context , String key, int value){

        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static int getIntSharedPreference(Context context,String key){
        return getSharedPreference(context).getInt(key,0);
    }



    public static void writeStringSharedPreference(Context context ,String key, String value){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static String getStringSharedPreference(Context context,String key){
        return getSharedPreference(context).getString(key,null);
    }
}
