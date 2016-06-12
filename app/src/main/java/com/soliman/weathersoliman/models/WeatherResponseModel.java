
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponseModel {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("termsofService")
    @Expose
    private String termsofService;
    @SerializedName("features")
    @Expose
    private FeaturesModel featuresModel;

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The termsofService
     */
    public String getTermsofService() {
        return termsofService;
    }

    /**
     * 
     * @param termsofService
     *     The termsofService
     */
    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    /**
     * 
     * @return
     *     The features
     */
    public FeaturesModel getFeaturesModel() {
        return featuresModel;
    }

    /**
     *
     * @param featuresModel
     *     The features
     */
    public void setFeaturesModel(FeaturesModel featuresModel) {
        this.featuresModel = featuresModel;
    }

}
