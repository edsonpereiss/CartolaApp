package com.app.sportsmobile.cartola.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Edson on 01/02/2017.
 */
public class SessionManager {

    public static final String PREF_NAME = "LoginPref";
    public static final String KEY_TOKEN = "token";


    public static void saveSetting(Context mContext, String mKey, String mValue) {
        SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(mKey, mValue);
        editor.commit();
    }

    public static String getSetting(Context mContext, String mKey, String mDefValue) {
        SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(mKey, mDefValue);
    }

    public static String getToken(Context mContext) {
        return getSetting(mContext, KEY_TOKEN, null);
    }

    public static void setToken(Context mContext, String mValue) {
        saveSetting(mContext, KEY_TOKEN, mValue);

    }
    public static void logoutUser(Context mContext){
        // Clearing all data from Shared Preferences
        SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


}
