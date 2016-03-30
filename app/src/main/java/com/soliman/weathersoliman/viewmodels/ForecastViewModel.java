package com.soliman.weathersoliman.viewmodels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.duowan.mobile.netroid.Listener;
import com.duowan.mobile.netroid.NetroidError;
import com.duowan.mobile.netroid.RequestQueue;
import com.duowan.mobile.netroid.cache.DiskCache;
import com.duowan.mobile.netroid.request.StringRequest;
import com.google.gson.Gson;
import com.soliman.weathersoliman.models.WeatherResponse;
import com.soliman.weathersoliman.utils.ForecastListener;
import com.soliman.weathersoliman.utils.Netroid;
import com.soliman.weathersoliman.utils.Util;

import java.io.File;

/**
 * Created by islam on 3/30/2016.
 */
public class ForecastViewModel {
    private RequestQueue mQueue;
    ProgressDialog mPrgsDialog;

    private static ForecastViewModel instance;

    public static ForecastViewModel getInstance() {
        if (instance == null) {
            instance = new ForecastViewModel();
        }
        return instance;
    }

    public void getForecastdays(final Activity context, final ForecastListener forecastListener) {
        File diskCacheDir = new File(context.getCacheDir(), "netroid");
        int diskCacheSize = 50 * 1024 * 1024; // 50MB
        mQueue = Netroid.newRequestQueue(context, new DiskCache(diskCacheDir, diskCacheSize));
        StringRequest request = new StringRequest(Util.url, new Listener<String>() {

            @Override
            public void onPreExecute() {
                mPrgsDialog = ProgressDialog.show(context, null, "loading...", true, true);
            }

            // cancel the dialog with onFinish() callback
            @Override
            public void onFinish() {
                mPrgsDialog.cancel();
            }

            @Override
            public void onSuccess(String response) {
                WeatherResponse weatherResponse = new Gson().fromJson(response, WeatherResponse.class);
                forecastListener.onSuccess(weatherResponse);

            }

            @Override
            public void onError(NetroidError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "request was cancel", Toast.LENGTH_LONG).show();
            }
        });

// add the request to RequestQueue, will execute quickly if has idle thread
        mQueue.add(request);


    }


}