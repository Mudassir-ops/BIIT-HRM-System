package com.example.biithrmsystem.commons;

import android.preference.PreferenceManager;

import com.example.biithrmsystem.AppController;

public class SharedPreferences {

    private static final String APPLICANT_ID = "APPLICANT_ID";
    private static final String LOGGED_IN_EMAIL = "LOGGED_IN_EMAIL";
    private static final String LOGGED_IN_PASSWORD = "LOGGED_IN_PASSWORD";
    private static final String CHECKED_IN_USER_0 = "CHECKED_IN_USER_0";
    private static final String CHECKED_IN_USER_1 = "CHECKED_IN_USER_1";
    private static final String CHECKED_IN_USER_2 = "CHECKED_IN_USER_2";
    private static final String CHECKED_IN_USER_3 = "CHECKED_IN_USER_3";
    private static final String CHECKED_IN_USER_4 = "CHECKED_IN_USER_4";
    private static final String CHECKED_IN_USER_5 = "CHECKED_IN_USER_5";
    private static final String CHECKED_IN_USER_6 = "CHECKED_IN_USER_6";
    private static final String CHECKED_IN_USER_7 = "CHECKED_IN_USER_7";
    private static final String CHECKED_IN_USER_8 = "CHECKED_IN_USER_8";
    private static final String CHECKED_IN_USER_9 = "CHECKED_IN_USER_9";
    private static final String CHECKED_IN_USER_10 = "CHECKED_IN_USER_10";
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


    public static void setCheckedInUser0(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_0, token);
        editor.apply();
    }

    public static String GetCheckedInUser0() {
        return preferences.getString(CHECKED_IN_USER_0, "");
    }


    public static void setCheckedInUser1(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_1, token);
        editor.apply();
    }

    public static String GetCheckedInUser1() {
        return preferences.getString(CHECKED_IN_USER_1, "");
    }


    public static void setCheckedInUser2(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_2, token);
        editor.apply();
    }

    public static String GetCheckedInUser2() {
        return preferences.getString(CHECKED_IN_USER_2, "");
    }


    public static void setCheckedInUser3(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_3, token);
        editor.apply();
    }

    public static String GetCheckedInUser3() {
        return preferences.getString(CHECKED_IN_USER_3, "");
    }


    public static void setCheckedInUser4(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_4, token);
        editor.apply();
    }

    public static String GetCheckedInUser4() {
        return preferences.getString(CHECKED_IN_USER_4, "");
    }


    public static void setCheckedInUser5(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_5, token);
        editor.apply();
    }

    public static String GetCheckedInUser5() {
        return preferences.getString(CHECKED_IN_USER_5, "");
    }


    public static void setCheckedInUser6(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_6, token);
        editor.apply();
    }

    public static String GetCheckedInUser6() {
        return preferences.getString(CHECKED_IN_USER_6, "");
    }


    public static void setCheckedInUser7(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_7, token);
        editor.apply();
    }

    public static String GetCheckedInUser7() {
        return preferences.getString(CHECKED_IN_USER_7, "");
    }


    public static void setCheckedInUser8(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_8, token);
        editor.apply();
    }

    public static String GetCheckedInUser8() {
        return preferences.getString(CHECKED_IN_USER_8, "");
    }


    public static void setCheckedInUser9(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_9, token);
        editor.apply();
    }

    public static String GetCheckedInUser9() {
        return preferences.getString(CHECKED_IN_USER_9, "");
    }


    public static void setCheckedInUser10(String token) {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CHECKED_IN_USER_10, token);
        editor.apply();
    }

    public static String GetCheckedInUser10() {
        return preferences.getString(CHECKED_IN_USER_10, "");
    }

}
