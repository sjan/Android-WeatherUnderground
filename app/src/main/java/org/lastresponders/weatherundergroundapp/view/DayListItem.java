package org.lastresponders.weatherundergroundapp.view;

/**
 * Created by sjan on 2/8/2015.
 */
public class DayListItem {
    private String date;
    private String tempHigh;
    private String tempLow;
    private String conditions;
    private String aveHumidity;
    private String aveWind;

    public String getTempHigh() {
        return tempHigh;
    }

    public void setTempHigh(String tempHigh) {
        this.tempHigh = tempHigh;
    }

    public String getTempLow() {
        return tempLow;
    }

    public void setTempLow(String tempLow) {
        this.tempLow = tempLow;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getAveHumidity() {
        return aveHumidity;
    }

    public void setAveHumidity(String aveHumidity) {
        this.aveHumidity = aveHumidity;
    }

    public String getAveWind() {
        return aveWind;
    }

    public void setAveWind(String aveWind) {
        this.aveWind = aveWind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
