package com.sumlimecorpdemo.assignment.demo.model;

import android.app.Application;
import android.content.Context;

/**
 * Created by pratiksha on 1/6/2008.
 */

public class App extends Application {

    private static App mContext;
    private static AppData mAppData;

    public static AppData appData () {
        return mAppData;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppData = new AppData();
        mContext = this;
        appData().doSetup();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
