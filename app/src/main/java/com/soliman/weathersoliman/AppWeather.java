package com.soliman.weathersoliman;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.soliman.weathersoliman.utils.Shared;

/**
 * Created by islam on 3/29/2016.
 */
public class AppWeather extends Application {

    private static Context applicationContext;

    public static Context getContext() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        AppWeather.applicationContext = getApplicationContext();
        Shared.getInstance();
    }

    @Override
    public void onTerminate() {
        FlowManager.destroy();
        super.onTerminate();
    }
}
