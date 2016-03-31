package com.soliman.weathersoliman.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.soliman.weathersoliman.models.Forecastday_;

import java.util.List;

/**
 * Created by islam on 3/29/2016.
 */
@Table(database = ForecastDatabase.class)
public class ForecastModel extends BaseModel {

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
    private static ForecastModel instance;

    public static ForecastModel getInstance() {
        if (instance == null) {
            instance = new ForecastModel();
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
    public List<ForecastModel> getForecasts() {
        List<ForecastModel> models = SQLite.select().from(ForecastModel.class).queryList();
        return models;

    }

    public void saveForecasts(List<Forecastday_> forecastday) {
        SQLite.delete().from(ForecastModel.class).execute();
        for (Forecastday_ day : forecastday) {
            ForecastModel model = new ForecastModel();
            String date = day.getDate().getDay() + " / " + day.getDate().getMonthname() + " / " + day.getDate().getYear();
            model.setDescription(day.getDate().getWeekday());
            model.setImageLink(day.getIconUrl());
            model.setDate(date);
            model.setDegreeHigh(day.getHigh().getCelsius() + "°");
            model.setCondition(day.getConditions());
            model.save();
        }
    }
}
