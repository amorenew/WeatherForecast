package com.soliman.weathersoliman;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by islam on 3/29/2016.
 */
public class AppWeather extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        FlowManager.destroy();
        super.onTerminate();
    }
}
