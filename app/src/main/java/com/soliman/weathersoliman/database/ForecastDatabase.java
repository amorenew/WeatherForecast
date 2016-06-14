package com.soliman.weathersoliman.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by islam on 3/29/2016.
 */

/**
 * Database config class
 */
@Database(name = ForecastDatabase.NAME, version = ForecastDatabase.VERSION)
public class ForecastDatabase {
    //database name without .db or .sqlite
    public static final String NAME = "Forecast";
    //database version number
    public static final int VERSION = 1;

}
