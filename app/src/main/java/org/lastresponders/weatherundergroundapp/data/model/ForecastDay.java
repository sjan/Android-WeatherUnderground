package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by stephenjan on 2/5/15.
 */
public class ForecastDay{
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

    @Override
    public String toString() {
        return "ForecastDay{" +
                "date='" + date + '\'' +
                ", tempHigh='" + tempHigh + '\'' +
                ", tempLow='" + tempLow + '\'' +
                ", conditions='" + conditions + '\'' +
                ", aveHumidity='" + aveHumidity + '\'' +
                ", aveWind='" + aveWind + '\'' +
                '}';
    }
}
