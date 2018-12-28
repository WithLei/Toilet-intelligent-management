package com.android.renly.toilet;

import android.app.Application;
import android.content.Context;

import com.android.renly.toilet.api.RetrofitService;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initConfig();
    }

    private void initConfig() {
        RetrofitService.init();
    }

    public static Context getContext(){
        return context;
    }

}
