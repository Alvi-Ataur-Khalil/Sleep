package com.example.alvi.sleep.HelperClasses;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;


import java.util.Locale;



public class App extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();


        mContext = this;
    }
    public static Context getContext(){
        return mContext;
    }


}
