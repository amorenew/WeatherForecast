package com.soliman.weathersoliman.viewcontrollers;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.adapters.ForecastAdapter;
import com.soliman.weathersoliman.database.ForecastModel;
import com.soliman.weathersoliman.models.WeatherModel;
import com.soliman.weathersoliman.utils.Util;
import com.soliman.weathersoliman.utils.webservice.WebServiceListener;
import com.soliman.weathersoliman.viewmodels.ForecastViewModel;

import java.util.List;

public class MainViewController extends AppCompatActivity implements WebServiceListener {

    private RecyclerView rvWeather;
    private Context context;
    private ForecastViewModel forecastViewModel;
    private ForecastModel forecastModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view_controller);
        context = getApplicationContext();
        forecastViewModel = ForecastViewModel.getInstance();
        forecastModel = ForecastModel.getInstance();

        rvWeather = (RecyclerView) findViewById(R.id.rvWeather);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        rvWeather.setLayoutManager(mLayoutManager);
        rvWeather.setItemAnimator(new DefaultItemAnimator());
        rvWeather.setAdapter(null);


        if (Util.getInstance().isInternetAvailable(context)) {
            forecastViewModel.getData(this, MainViewController.this, true);
        } else {
            // if no internet get forecasts from DB
            List<ForecastModel> forecastModels = forecastModel.getForecasts();
            ForecastAdapter forecastAdapter = new ForecastAdapter(forecastModels, context);
            rvWeather.swapAdapter(forecastAdapter, false);
        }

    }

    @Override
    public void onSuccess(Object response, String apiName) {
        WeatherModel weatherModel = (WeatherModel) response;
        // save forecasts in DB
        forecastModel.saveForecasts(weatherModel.getForecastModel().getSimpleforecastModel().getForecastday());

        List<ForecastModel> forecastModels = forecastModel.getForecasts();
        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastModels, context);
        rvWeather.swapAdapter(forecastAdapter, false);
    }

    @Override
    public void onError(String errorMessage) {

    }
}
