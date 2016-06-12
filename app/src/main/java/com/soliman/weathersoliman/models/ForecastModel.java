
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastModel {

    @SerializedName("txt_forecast")
    @Expose
    private TxtForecastModel txtForecastModel;
    @SerializedName("simpleforecast")
    @Expose
    private SimpleforecastModel simpleforecastModel;

    /**
     * 
     * @return
     *     The txtForecast
     */
    public TxtForecastModel getTxtForecastModel() {
        return txtForecastModel;
    }

    /**
     *
     * @param txtForecastModel
     *     The txt_forecast
     */
    public void setTxtForecastModel(TxtForecastModel txtForecastModel) {
        this.txtForecastModel = txtForecastModel;
    }

    /**
     * 
     * @return
     *     The simpleforecast
     */
    public SimpleforecastModel getSimpleforecastModel() {
        return simpleforecastModel;
    }

    /**
     *
     * @param simpleforecastModel
     *     The simpleforecast
     */
    public void setSimpleforecastModel(SimpleforecastModel simpleforecastModel) {
        this.simpleforecastModel = simpleforecastModel;
    }

}
