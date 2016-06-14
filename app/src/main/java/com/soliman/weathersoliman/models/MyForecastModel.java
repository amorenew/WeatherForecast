package com.soliman.weathersoliman.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.soliman.weathersoliman.database.ForecastDatabase;

import java.util.List;

/**
 * Created by islam on 3/29/2016.
 */
@Table(database = ForecastDatabase.class)
public class MyForecastModel extends BaseModel {

    private static MyForecastModel instance;
    @PrimaryKey(autoincrement = true)
    private int id;
    @Column
    private String imageLink;
    @Column
    private String description;
    @Column
    private String date;
    @Column
    private String degreeHigh;
    @Column
    private String condition;

    public static MyForecastModel getInstance() {
        if (instance == null) {
            instance = new MyForecastModel();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDegreeHigh() {
        return degreeHigh;
    }

    public void setDegreeHigh(String degreeHigh) {
        this.degreeHigh = degreeHigh;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<MyForecastModel> getForecasts() {
        List<MyForecastModel> models = SQLite.select().from(MyForecastModel.class).queryList();
        return models;

    }

    public void saveForecasts(List<Forecastday_Model> forecastday) {
        SQLite.delete().from(MyForecastModel.class).execute();
        for (Forecastday_Model day : forecastday) {
            MyForecastModel model = new MyForecastModel();
            String date = day.getDateModel().getDay() + " / " + day.getDateModel().getMonthname() + " / " + day.getDateModel().getYear();
            model.setDescription(day.getDateModel().getWeekday());
            model.setImageLink(day.getIconUrl());
            model.setDate(date);
            model.setDegreeHigh(day.getHighModel().getCelsius() + "°");
            model.setCondition(day.getConditions());
            model.save();
        }
    }
}
