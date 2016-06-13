package com.soliman.weathersoliman;

import android.app.Application;
import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.soliman.weathersoliman.utils.Shared;

/**
 * Created by islam on 3/29/2016.
 */
public class AppWeather extends Application {

    private static Context applicationContext;
    /**
     * The {@code FirebaseAnalytics} used to record screen views.
     */
    // [START declare_analytics]
    private static FirebaseAnalytics firebaseAnalytics;
    // [END declare_analytics]

    public static Context getContext() {
        return applicationContext;
    }

    public static FirebaseAnalytics getAnalytics() {
        return firebaseAnalytics;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        AppWeather.applicationContext = getApplicationContext();
        Shared.getInstance();
        // Util.getInstance().setLocale(this);
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

    @Override
    public void onTerminate() {
        FlowManager.destroy();
        super.onTerminate();
    }
}
