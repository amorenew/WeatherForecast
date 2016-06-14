package com.soliman.weathersoliman.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.soliman.weathersoliman.AppWeather;
import com.soliman.weathersoliman.Constants;

/**
 * Created by amorenew on 11/05/2016.
 */

/**
 * to save and retrieve shared preferences values
 */
public class Shared {
    private static Shared instance;
    private SharedPreferences preferences;
    private String LanguageKey = "LanguageKey";

    private Shared(Context context) {
        preferences = context.getSharedPreferences(Shared.class.getSimpleName(), Context.MODE_PRIVATE);
    }

    public static Shared getInstance() {
        if (instance == null) {
            instance = new Shared(AppWeather.getContext());
        }
        return instance;
    }

    /**
     * save language preference
     *
     * @param languageKey
     */
    public void saveLanguage(String languageKey) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(LanguageKey, languageKey);
        edit.apply();
    }

    /**
     * to get the stored language preference
     *
     * @return
     */
    public String getLanguage() {
        String language = preferences.getString(LanguageKey, Constants.EnglishLanguageCode);
        return language;
    }

    /**
     * check if saved language is english language
     *
     * @return
     */
    public boolean isEnglish() {
        return (getLanguage().equals(Constants.EnglishLanguageCode));
    }

}
