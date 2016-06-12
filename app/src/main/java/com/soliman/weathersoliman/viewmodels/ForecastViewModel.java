package com.soliman.weathersoliman.viewmodels;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.soliman.weathersoliman.Constants;
import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.models.WeatherModel;
import com.soliman.weathersoliman.utils.webservice.VolleyRequestManager;
import com.soliman.weathersoliman.utils.webservice.VolleyResponsable;
import com.soliman.weathersoliman.utils.webservice.WebServiceListener;

/**
 * Created by islam on 3/30/2016.
 */
public class ForecastViewModel implements VolleyResponsable {
    private static ForecastViewModel instance;
    ProgressDialog mProgressDialog;
    Context context;
    private WebServiceListener webServiceListener;

    public static ForecastViewModel getInstance() {
        if (instance == null) {
            instance = new ForecastViewModel();
        }
        return instance;
    }

    public void getData(Context context, final WebServiceListener webServiceListener, boolean isProgressDialogEnabled) {
        this.context = context;
        this.context = context;
        this.webServiceListener = webServiceListener;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(R.string.loading));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setCancelable(false);
        if (isProgressDialogEnabled)
            mProgressDialog.show();
        VolleyRequestManager.getInstance(context).pullJsonObject(Constants.getCairoForecast(), Request.Method.GET, this, Constants.getCairoForecast(), null);
        Log.d(WeatherModel.class.getSimpleName(), "getData");
    }


    @Override
    public void onJsonResponse(Object response, String apiName) {
        WeatherModel weatherModel = new Gson().fromJson(response.toString(), WeatherModel.class);
        webServiceListener.onSuccess(weatherModel, Constants.getCairoForecast());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        Log.d(WeatherModel.class.getSimpleName(), "onJsonResponse");
    }

    @Override
    public void onError(VolleyError error, String apiName) {
        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
        webServiceListener.onError(apiName + " " + error.getMessage());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        Log.d(WeatherModel.class.getSimpleName(), "onError");

    }
}