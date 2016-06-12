
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

    @SerializedName("response")
    @Expose
    private WeatherResponseModel weatherResponseModel;
    @SerializedName("forecast")
    @Expose
    private ForecastModel forecastModel;

    /**
     * 
     * @return
     *     The response
     */
    public WeatherResponseModel getWeatherResponseModel() {
        return weatherResponseModel;
    }

    /**
     *
     * @param weatherResponseModel
     *     The response
     */
    public void setWeatherResponseModel(WeatherResponseModel weatherResponseModel) {
        this.weatherResponseModel = weatherResponseModel;
    }

    /**
     * 
     * @return
     *     The forecast
     */
    public ForecastModel getForecastModel() {
        return forecastModel;
    }

    /**
     *
     * @param forecastModel
     *     The forecast
     */
    public void setForecastModel(ForecastModel forecastModel) {
        this.forecastModel = forecastModel;
    }

}
