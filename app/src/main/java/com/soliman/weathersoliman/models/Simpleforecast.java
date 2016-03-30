
package com.soliman.weathersoliman.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Simpleforecast {

    @SerializedName("forecastday")
    @Expose
    private List<Forecastday_> forecastday = new ArrayList<Forecastday_>();

    /**
     * 
     * @return
     *     The forecastday
     */
    public List<Forecastday_> getForecastday() {
        return forecastday;
    }

    /**
     * 
     * @param forecastday
     *     The forecastday
     */
    public void setForecastday(List<Forecastday_> forecastday) {
        this.forecastday = forecastday;
    }

}
