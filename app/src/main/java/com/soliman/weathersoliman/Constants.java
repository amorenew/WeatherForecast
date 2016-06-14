package com.soliman.weathersoliman;

/**
 * Created by amor on 5/9/2016.
 */

/**
 * contain all app constant values
 */
public class Constants {
    public static final String EnglishLanguageCode = "en";
    public static final String ArabicLanguageCode = "ar";
    public static String ErrorCodeHTTP = "401";
    private static String LanguageCode = "LanguageCode";

    private static String BaseURL = "http://api.wunderground.com/api/";
    private static String CairoForecast = "838ed9367e8876bf%20/forecast/q/EG/Cairo.json";

    public static String getCairoForecast() {
        return BaseURL + CairoForecast;
    }

    private String getBaseURL() {
        return BaseURL;
    }
}
