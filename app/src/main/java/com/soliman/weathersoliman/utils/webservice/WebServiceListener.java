package com.soliman.weathersoliman.utils.webservice;


/**
 * Created by islam on 3/30/2016.
 */
public interface WebServiceListener {

    void onSuccess(Object response, String apiName);

    void onError(String errorMessage);

    void update();
}
