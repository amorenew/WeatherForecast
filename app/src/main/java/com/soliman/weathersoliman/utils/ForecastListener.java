package com.soliman.weathersoliman.utils;

import com.soliman.weathersoliman.models.WeatherResponse;

/**
 * Created by islam on 3/30/2016.
 */
public interface ForecastListener {

    public void onSuccess(WeatherResponse weatherResponse);

}
