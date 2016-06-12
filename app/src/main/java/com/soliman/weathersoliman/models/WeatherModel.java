
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    /**
     * 
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * 
     * @return
     *     The forecast
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     * 
     * @param forecast
     *     The forecast
     */
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

}
