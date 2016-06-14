package com.soliman.weathersoliman.utils.webservice;

import com.android.volley.VolleyError;

/**
 * Created by sabouelsouod on 8/25/2015.
 */
public interface VolleyListener {
    void onJsonResponse(Object response, String apiName);

    void onError(VolleyError error, String apiName);
}
