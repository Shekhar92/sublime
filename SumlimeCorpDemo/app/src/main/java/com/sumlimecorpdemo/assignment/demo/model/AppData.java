package com.sumlimecorpdemo.assignment.demo.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import com.sumlimecorpdemo.assignment.demo.Constants;

import static com.sumlimecorpdemo.assignment.demo.Constants.LATITUDE;
import static com.sumlimecorpdemo.assignment.demo.Constants.LONGITUDE;

/**
 * Created by pratiksha on 1/6/2008.
 */

public class AppData {

    protected Typeface typeface100;
    protected Typeface typeface300;
    protected Typeface typeface500;
    protected SharedPreferences preferences;
    protected SharedPreferences.Editor preferenceEditor;


    public void doSetup() {
        // Timber.v("Starting app data setup ===================================>>>>>>");
        Context appContext = App.getAppContext();
        preferences = appContext.getSharedPreferences(Constants.PREFERENCE, 0);
        preferenceEditor = preferences.edit();
        //   EventBus.getDefault().register(this);

        //   preferences = appContext.getSharedPreferences(PREFERENCE, 0);
        //    preferenceEditor = preferences.edit();
//        if (getIsLogin() == "true") {
//           // show upload fragment
//        } else {
//            //show login fragment
//        }

        //forceUpdateRequired = 0;

        // setupHasCompleted = true;

//        typeface100 = Typeface.createFromAsset(appContext.getAssets(), "fonts/MuseoSans-100_0.otf");
//        typeface300 = Typeface.createFromAsset(appContext.getAssets(), "fonts/MuseoSans-300_0.otf");
//        typeface500 = Typeface.createFromAsset(appContext.getAssets(), "fonts/museosans-500.otf");

        //  Timber.v("Finished app data setup <<<<<<<<===================================");

    }



    public void savelatlong(String latitude, String longitude) {
        if(preferenceEditor==null){
            return;
        }
        preferenceEditor.putString(LATITUDE, latitude);
        preferenceEditor.putString(LONGITUDE, longitude);
        preferenceEditor.apply();
    }

    public String getLatitude() {
        return preferences.getString(LATITUDE, "0");
    }

    public String getLongitude() {
        return preferences.getString(LONGITUDE, "0");
    }

    public Typeface getTypeface100() {
        return typeface100;
    }

    public Typeface getTypeface300() {
        return typeface300;
    }

    public Typeface getTypeface500() {
        return typeface500;
    }


}
