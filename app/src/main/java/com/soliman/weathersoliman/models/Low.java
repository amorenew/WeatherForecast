
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Low {

    @SerializedName("fahrenheit")
    @Expose
    private String fahrenheit;
    @SerializedName("celsius")
    @Expose
    private String celsius;

    /**
     * 
     * @return
     *     The fahrenheit
     */
    public String getFahrenheit() {
        return fahrenheit;
    }

    /**
     * 
     * @param fahrenheit
     *     The fahrenheit
     */
    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    /**
     * 
     * @return
     *     The celsius
     */
    public String getCelsius() {
        return celsius;
    }

    /**
     * 
     * @param celsius
     *     The celsius
     */
    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

}
