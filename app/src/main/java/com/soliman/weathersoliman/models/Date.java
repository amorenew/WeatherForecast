
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("epoch")
    @Expose
    private String epoch;
    @SerializedName("pretty")
    @Expose
    private String pretty;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("month")
    @Expose
    private Integer month;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("yday")
    @Expose
    private Integer yday;
    @SerializedName("hour")
    @Expose
    private Integer hour;
    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("sec")
    @Expose
    private Integer sec;
    @SerializedName("isdst")
    @Expose
    private String isdst;
    @SerializedName("monthname")
    @Expose
    private String monthname;
    @SerializedName("monthname_short")
    @Expose
    private String monthnameShort;
    @SerializedName("weekday_short")
    @Expose
    private String weekdayShort;
    @SerializedName("weekday")
    @Expose
    private String weekday;
    @SerializedName("ampm")
    @Expose
    private String ampm;
    @SerializedName("tz_short")
    @Expose
    private String tzShort;
    @SerializedName("tz_long")
    @Expose
    private String tzLong;

    /**
     * 
     * @return
     *     The epoch
     */
    public String getEpoch() {
        return epoch;
    }

    /**
     * 
     * @param epoch
     *     The epoch
     */
    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    /**
     * 
     * @return
     *     The pretty
     */
    public String getPretty() {
        return pretty;
    }

    /**
     * 
     * @param pretty
     *     The pretty
     */
    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    /**
     * 
     * @return
     *     The day
     */
    public Integer getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * 
     * @return
     *     The month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 
     * @param month
     *     The month
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     The yday
     */
    public Integer getYday() {
        return yday;
    }

    /**
     * 
     * @param yday
     *     The yday
     */
    public void setYday(Integer yday) {
        this.yday = yday;
    }

    /**
     * 
     * @return
     *     The hour
     */
    public Integer getHour() {
        return hour;
    }

    /**
     * 
     * @param hour
     *     The hour
     */
    public void setHour(Integer hour) {
        this.hour = hour;
    }

    /**
     * 
     * @return
     *     The min
     */
    public String getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The sec
     */
    public Integer getSec() {
        return sec;
    }

    /**
     * 
     * @param sec
     *     The sec
     */
    public void setSec(Integer sec) {
        this.sec = sec;
    }

    /**
     * 
     * @return
     *     The isdst
     */
    public String getIsdst() {
        return isdst;
    }

    /**
     * 
     * @param isdst
     *     The isdst
     */
    public void setIsdst(String isdst) {
        this.isdst = isdst;
    }

    /**
     * 
     * @return
     *     The monthname
     */
    public String getMonthname() {
        return monthname;
    }

    /**
     * 
     * @param monthname
     *     The monthname
     */
    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    /**
     * 
     * @return
     *     The monthnameShort
     */
    public String getMonthnameShort() {
        return monthnameShort;
    }

    /**
     * 
     * @param monthnameShort
     *     The monthname_short
     */
    public void setMonthnameShort(String monthnameShort) {
        this.monthnameShort = monthnameShort;
    }

    /**
     * 
     * @return
     *     The weekdayShort
     */
    public String getWeekdayShort() {
        return weekdayShort;
    }

    /**
     * 
     * @param weekdayShort
     *     The weekday_short
     */
    public void setWeekdayShort(String weekdayShort) {
        this.weekdayShort = weekdayShort;
    }

    /**
     * 
     * @return
     *     The weekday
     */
    public String getWeekday() {
        return weekday;
    }

    /**
     * 
     * @param weekday
     *     The weekday
     */
    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    /**
     * 
     * @return
     *     The ampm
     */
    public String getAmpm() {
        return ampm;
    }

    /**
     * 
     * @param ampm
     *     The ampm
     */
    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    /**
     * 
     * @return
     *     The tzShort
     */
    public String getTzShort() {
        return tzShort;
    }

    /**
     * 
     * @param tzShort
     *     The tz_short
     */
    public void setTzShort(String tzShort) {
        this.tzShort = tzShort;
    }

    /**
     * 
     * @return
     *     The tzLong
     */
    public String getTzLong() {
        return tzLong;
    }

    /**
     * 
     * @param tzLong
     *     The tz_long
     */
    public void setTzLong(String tzLong) {
        this.tzLong = tzLong;
    }

}
