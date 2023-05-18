package com.example.biithrmsystem;

import android.app.Activity;
import android.app.Application;

public class AppController extends Application {

    private static AppController appController = null;
    private static Activity activity = null;

    public AppController() {
        appController = this;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void setActivity(Activity activity) {
        AppController.activity = activity;
    }

    public static synchronized AppController getInstance() {
        return appController;
    }
}
