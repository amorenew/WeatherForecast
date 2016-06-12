package com.soliman.weathersoliman;

import com.soliman.weathersoliman.utils.Shared;

/**
 * Created by amor on 5/9/2016.
 */
public class Constants {
    public static final String EnglishLanguageCode = "en";
    public static final String ArabicLanguageCode = "ar";
    public static String ErrorCodeHTTP = "401";
    private static String LanguageCode = "LanguageCode";

    private static String BaseURL = "http://api.wunderground.com/api/";
    private static String CairoForecast = "838ed9367e8876bf%20/forecast/q/EG/Cairo.json";

    public static String getLanguageCode() {
        String languageCode = Shared.getInstance().getLanguage();
        if (languageCode == null)
            return Constants.EnglishLanguageCode;
        return languageCode;
    }

    public static String getCairoForecast() {
        return BaseURL + CairoForecast;
    }

    private String getBaseURL() {
        return BaseURL;
    }
}
