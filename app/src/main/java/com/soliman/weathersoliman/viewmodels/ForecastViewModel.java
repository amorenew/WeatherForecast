package com.soliman.weathersoliman.viewmodels;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.soliman.weathersoliman.Constants;
import com.soliman.weathersoliman.models.WeatherModel;
import com.soliman.weathersoliman.utils.webservice.ViewModel;
import com.soliman.weathersoliman.utils.webservice.VolleyRequestManager;
import com.soliman.weathersoliman.utils.webservice.WebServiceListener;

/**
 * Created by islam on 3/30/2016.
 */

/**
 * for calling webservice and sending data to view controller
 */
public class ForecastViewModel extends ViewModel implements WebServiceListener {

    public void getData(Context context, final WebServiceListener webServiceListener, boolean isProgressDialogEnabled) {
        super.getData(context, webServiceListener, isProgressDialogEnabled);
        VolleyRequestManager.getInstance(context).pullJsonObject(Constants.getCairoForecast(), Request.Method.GET, this, Constants.getCairoForecast(), null);
        Log.d(WeatherModel.class.getSimpleName(), "getData");
    }

    @Override
    public void onSuccess(Object response, String apiName) {
        super.onSuccess(response, apiName);
        //parse response to data model
        WeatherModel weatherModel = new Gson().fromJson(response.toString(), WeatherModel.class);
        //send result to view controller
        webServiceListener.onSuccess(weatherModel, Constants.getCairoForecast());
        Log.d(WeatherModel.class.getSimpleName(), "onJsonResponse");
    }

    @Override
    public void onError(VolleyError error, String apiName) {
        super.onError(error, apiName);
        Log.d(WeatherModel.class.getSimpleName(), "onError");
    }

    @Override
    public void update() {
        getData(context, webServiceListener, isProgressDialogEnabled);
    }
}