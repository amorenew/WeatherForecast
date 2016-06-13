package com.soliman.weathersoliman.viewcontrollers;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.soliman.weathersoliman.AppWeather;
import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.database.ForecastModel;
import com.soliman.weathersoliman.models.WeatherModel;
import com.soliman.weathersoliman.utils.Util;
import com.soliman.weathersoliman.utils.webservice.WebServiceListener;
import com.soliman.weathersoliman.viewmodels.ForecastViewModel;
import com.soliman.weathersoliman.views.RecyclerItemClickListener;
import com.soliman.weathersoliman.views.adapters.ForecastAdapter;

import java.util.List;

public class MainViewController extends BaseViewController implements WebServiceListener {

    List<ForecastModel> forecastModels;
    private RecyclerView rvWeather;
    private Context context;
    private ForecastViewModel forecastViewModel;
    private ForecastModel forecastModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        context = getApplicationContext();
        forecastViewModel = ForecastViewModel.getInstance();
        forecastModel = ForecastModel.getInstance();

        rvWeather = (RecyclerView) findViewById(R.id.rvWeather);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        rvWeather.setLayoutManager(mLayoutManager);
        rvWeather.setItemAnimator(new DefaultItemAnimator());
        rvWeather.setAdapter(null);
        rvWeather.addOnItemTouchListener(
                new RecyclerItemClickListener(MainViewController.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), forecastModels.get(position).getDate(), Toast.LENGTH_LONG).show();
                    }
                })
        );

        if (Util.getInstance().isInternetAvailable(context)) {
            forecastViewModel.getData(this, MainViewController.this, true);
        } else {
            // if no internet get forecasts from DB
            List<ForecastModel> forecastModels = forecastModel.getForecasts();
            ForecastAdapter forecastAdapter = new ForecastAdapter(forecastModels, context);
            rvWeather.swapAdapter(forecastAdapter, false);
        }
        FirebaseCrash.log("Main View Log 1");
        FirebaseCrash.report(new Exception("No Internet non-fatal error"));

        initNotification();
        subscribeToNewsNotifications();
        Log.d(this.getClass().getSimpleName(), "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());

        // [START user_property]
        AppWeather.getAnalytics().setUserProperty("Property: Name", "Amr");
        // [END user_property]
        // [START custom_event]
        Bundle params = new Bundle();
        params.putString("image_name", "Ahmed");
        params.putString("full_text", "Ahmed Basem");
        AppWeather.getAnalytics().logEvent("User Info", params);
        // [END custom_event]
        // [START image_view_event]
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.PRICE, "100");
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, "B.D.");
        AppWeather.getAnalytics().logEvent(FirebaseAnalytics.Event.ADD_PAYMENT_INFO, bundle);
        // [END image_view_event]*/
        Util.getInstance().setLocale(this);
        addNavigationDrawer();
        setTitle(getString(R.string.main));
        setMenuIndex(R.string.main);
    }


    private void subscribeToNewsNotifications() {
        // [START subscribe_topics]
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        Log.d(this.getClass().getSimpleName(), "Subscribed to news topic");
        // [END subscribe_topics]

    }

    private void initNotification() {
        // If a notification message is tapped, any data accompanying the notification
        // message is available in the intent extras. In this sample the launcher
        // intent is fired when the notification is tapped, so any accompanying data would
        // be handled here. If you want a different intent fired, set the click_action
        // field of the notification message to the desired intent. The launcher intent
        // is used when no click_action is specified.
        //
        // Handle possible data accompanying notification message.
        // [START handle_data_extras]
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d(this.getClass().getSimpleName(), "Key: " + key + " Value: " + value);
            }
        }
        // [END handle_data_extras]
    }

    @Override
    public void onSuccess(Object response, String apiName) {
        WeatherModel weatherModel = (WeatherModel) response;
        // save forecasts in DB
        forecastModel.saveForecasts(weatherModel.getForecastModel().getSimpleforecastModel().getForecastday());

        forecastModels = forecastModel.getForecasts();
        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastModels, context);
        rvWeather.swapAdapter(forecastAdapter, false);
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void update() {

    }
}
