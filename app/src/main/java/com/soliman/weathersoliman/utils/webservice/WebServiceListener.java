package com.soliman.weathersoliman.utils.webservice;


/**
 * Created by islam on 3/30/2016.
 */

import com.android.volley.VolleyError;

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
     * @param error the error message
     */
    void onError(VolleyError error, String apiName);

    /**
     * use update to recall web service
     */
    void update();
}
