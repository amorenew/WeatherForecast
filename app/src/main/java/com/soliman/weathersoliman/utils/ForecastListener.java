package com.soliman.weathersoliman.utils;

import com.soliman.weathersoliman.models.WeatherModel;

/**
 * Created by islam on 3/30/2016.
 */
public interface ForecastListener {

    void onSuccess(WeatherModel weatherModel);

}
