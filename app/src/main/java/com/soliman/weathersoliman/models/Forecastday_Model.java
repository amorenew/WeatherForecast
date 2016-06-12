
package com.soliman.weathersoliman.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecastday_Model {

    @SerializedName("date")
    @Expose
    private DateModel dateModel;
    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("high")
    @Expose
    private HighModel highModel;
    @SerializedName("low")
    @Expose
    private LowModel lowModel;
    @SerializedName("conditions")
    @Expose
    private String conditions;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("skyicon")
    @Expose
    private String skyicon;
    @SerializedName("pop")
    @Expose
    private Integer pop;
    @SerializedName("qpf_allday")
    @Expose
    private QpfAlldayModel qpfAlldayModel;
    @SerializedName("qpf_day")
    @Expose
    private QpfDayModel qpfDayModel;
    @SerializedName("qpf_night")
    @Expose
    private QpfNightModel qpfNightModel;
    @SerializedName("snow_allday")
    @Expose
    private SnowAlldayModel snowAlldayModel;
    @SerializedName("snow_day")
    @Expose
    private SnowDayModel snowDayModel;
    @SerializedName("snow_night")
    @Expose
    private SnowNightModel snowNightModel;
    @SerializedName("maxwind")
    @Expose
    private MaxwindModel maxwindModel;
    @SerializedName("avewind")
    @Expose
    private AvewindModel avewindModel;
    @SerializedName("avehumidity")
    @Expose
    private Integer avehumidity;
    @SerializedName("maxhumidity")
    @Expose
    private Integer maxhumidity;
    @SerializedName("minhumidity")
    @Expose
    private Integer minhumidity;

    /**
     * 
     * @return
     *     The date
     */
    public DateModel getDateModel() {
        return dateModel;
    }

    /**
     *
     * @param dateModel
     *     The date
     */
    public void setDateModel(DateModel dateModel) {
        this.dateModel = dateModel;
    }

    /**
     * 
     * @return
     *     The period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 
     * @param period
     *     The period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 
     * @return
     *     The high
     */
    public HighModel getHighModel() {
        return highModel;
    }

    /**
     *
     * @param highModel
     *     The high
     */
    public void setHighModel(HighModel highModel) {
        this.highModel = highModel;
    }

    /**
     * 
     * @return
     *     The low
     */
    public LowModel getLowModel() {
        return lowModel;
    }

    /**
     *
     * @param lowModel
     *     The low
     */
    public void setLowModel(LowModel lowModel) {
        this.lowModel = lowModel;
    }

    /**
     * 
     * @return
     *     The conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 
     * @param conditions
     *     The conditions
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *     The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return
     *     The skyicon
     */
    public String getSkyicon() {
        return skyicon;
    }

    /**
     * 
     * @param skyicon
     *     The skyicon
     */
    public void setSkyicon(String skyicon) {
        this.skyicon = skyicon;
    }

    /**
     * 
     * @return
     *     The pop
     */
    public Integer getPop() {
        return pop;
    }

    /**
     * 
     * @param pop
     *     The pop
     */
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    /**
     * 
     * @return
     *     The qpfAllday
     */
    public QpfAlldayModel getQpfAlldayModel() {
        return qpfAlldayModel;
    }

    /**
     *
     * @param qpfAlldayModel
     *     The qpf_allday
     */
    public void setQpfAlldayModel(QpfAlldayModel qpfAlldayModel) {
        this.qpfAlldayModel = qpfAlldayModel;
    }

    /**
     * 
     * @return
     *     The qpfDay
     */
    public QpfDayModel getQpfDayModel() {
        return qpfDayModel;
    }

    /**
     *
     * @param qpfDayModel
     *     The qpf_day
     */
    public void setQpfDayModel(QpfDayModel qpfDayModel) {
        this.qpfDayModel = qpfDayModel;
    }

    /**
     * 
     * @return
     *     The qpfNight
     */
    public QpfNightModel getQpfNightModel() {
        return qpfNightModel;
    }

    /**
     *
     * @param qpfNightModel
     *     The qpf_night
     */
    public void setQpfNightModel(QpfNightModel qpfNightModel) {
        this.qpfNightModel = qpfNightModel;
    }

    /**
     * 
     * @return
     *     The snowAllday
     */
    public SnowAlldayModel getSnowAlldayModel() {
        return snowAlldayModel;
    }

    /**
     *
     * @param snowAlldayModel
     *     The snow_allday
     */
    public void setSnowAlldayModel(SnowAlldayModel snowAlldayModel) {
        this.snowAlldayModel = snowAlldayModel;
    }

    /**
     * 
     * @return
     *     The snowDay
     */
    public SnowDayModel getSnowDayModel() {
        return snowDayModel;
    }

    /**
     *
     * @param snowDayModel
     *     The snow_day
     */
    public void setSnowDayModel(SnowDayModel snowDayModel) {
        this.snowDayModel = snowDayModel;
    }

    /**
     * 
     * @return
     *     The snowNight
     */
    public SnowNightModel getSnowNightModel() {
        return snowNightModel;
    }

    /**
     *
     * @param snowNightModel
     *     The snow_night
     */
    public void setSnowNightModel(SnowNightModel snowNightModel) {
        this.snowNightModel = snowNightModel;
    }

    /**
     * 
     * @return
     *     The maxwind
     */
    public MaxwindModel getMaxwindModel() {
        return maxwindModel;
    }

    /**
     *
     * @param maxwindModel
     *     The maxwind
     */
    public void setMaxwindModel(MaxwindModel maxwindModel) {
        this.maxwindModel = maxwindModel;
    }

    /**
     * 
     * @return
     *     The avewindModel
     */
    public AvewindModel getAvewindModel() {
        return avewindModel;
    }

    /**
     *
     * @param avewindModel
     *     The avewindModel
     */
    public void setAvewindModel(AvewindModel avewindModel) {
        this.avewindModel = avewindModel;
    }

    /**
     * 
     * @return
     *     The avehumidity
     */
    public Integer getAvehumidity() {
        return avehumidity;
    }

    /**
     * 
     * @param avehumidity
     *     The avehumidity
     */
    public void setAvehumidity(Integer avehumidity) {
        this.avehumidity = avehumidity;
    }

    /**
     * 
     * @return
     *     The maxhumidity
     */
    public Integer getMaxhumidity() {
        return maxhumidity;
    }

    /**
     * 
     * @param maxhumidity
     *     The maxhumidity
     */
    public void setMaxhumidity(Integer maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    /**
     * 
     * @return
     *     The minhumidity
     */
    public Integer getMinhumidity() {
        return minhumidity;
    }

    /**
     * 
     * @param minhumidity
     *     The minhumidity
     */
    public void setMinhumidity(Integer minhumidity) {
        this.minhumidity = minhumidity;
    }

}
