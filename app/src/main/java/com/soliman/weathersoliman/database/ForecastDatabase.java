package com.soliman.weathersoliman.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by islam on 3/29/2016.
 */
@Database(name = ForecastDatabase.NAME, version = ForecastDatabase.VERSION)
public class ForecastDatabase {

    public static final String NAME = "Forecast";

    public static final int VERSION = 1;

}
