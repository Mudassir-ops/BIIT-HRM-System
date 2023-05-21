package com.example.biithrmsystem.commons;

import android.preference.PreferenceManager;

import com.example.biithrmsystem.AppController;

public class SharedPreferences {

    private static final String APPLICANT_ID = "APPLICANT_ID";
    private static final String LOGGED_IN_EMAIL = "LOGGED_IN_EMAIL";
    private static final String LOGGED_IN_PASSWORD = "LOGGED_IN_PASSWORD";
    public static android.content.SharedPreferences preferences;

    static {
        preferences = PreferenceManager.getDefaultSharedPreferences(AppController.getInstance());
    }

    public static void setLogInUserId(int token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(APPLICANT_ID, token);
        editor.apply();
    }

    public static int GetLogInUserId() {
        return preferences.getInt(APPLICANT_ID, 0);
    }


    public static void setEmailId(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LOGGED_IN_EMAIL, token);
        editor.apply();
    }

    public static String GetEmailId() {
        return preferences.getString(LOGGED_IN_EMAIL, "");
    }

    public static void setPassword(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LOGGED_IN_PASSWORD, token);
        editor.apply();
    }

    public static String GetPassword() {
        return preferences.getString(LOGGED_IN_PASSWORD, "");
    }

}
