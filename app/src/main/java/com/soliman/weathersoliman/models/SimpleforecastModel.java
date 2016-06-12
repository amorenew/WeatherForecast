
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SimpleforecastModel {

    @SerializedName("forecastday")
    @Expose
    private List<Forecastday_Model> forecastday = new ArrayList<Forecastday_Model>();

    /**
     * 
     * @return
     *     The forecastday
     */
    public List<Forecastday_Model> getForecastday() {
        return forecastday;
    }

    /**
     * 
     * @param forecastday
     *     The forecastday
     */
    public void setForecastday(List<Forecastday_Model> forecastday) {
        this.forecastday = forecastday;
    }

}
