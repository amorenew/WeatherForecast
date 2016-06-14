package com.soliman.weathersoliman.utils.webservice;


/**
 * Created by islam on 3/30/2016.
 */

/**
 * listen to web service call backs
 */
public interface WebServiceListener {
    /**
     * if response successfully called
     *
     * @param response the model result to web service
     * @param apiName  the web service name
     */
    void onSuccess(Object response, String apiName);

    /**
     * if response fail to return value
     * @param errorMessage the error message
     */
    void onError(String errorMessage);

    /**
     * use update to recall web service
     */
    void update();
}
