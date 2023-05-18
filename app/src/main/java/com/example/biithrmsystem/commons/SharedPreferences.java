package com.example.biithrmsystem.commons;

import android.preference.PreferenceManager;

import com.example.biithrmsystem.AppController;

public class SharedPreferences {

    private static final String APPLICANT_ID = "APPLICANT_ID";
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


}
