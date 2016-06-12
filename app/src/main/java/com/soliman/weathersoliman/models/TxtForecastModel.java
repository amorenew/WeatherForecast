
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TxtForecastModel {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("forecastday")
    @Expose
    private List<ForecastdayModel> forecastdayModel = new ArrayList<ForecastdayModel>();

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The forecastday
     */
    public List<ForecastdayModel> getForecastdayModel() {
        return forecastdayModel;
    }

    /**
     *
     * @param forecastdayModel
     *     The forecastday
     */
    public void setForecastdayModel(List<ForecastdayModel> forecastdayModel) {
        this.forecastdayModel = forecastdayModel;
    }

}
