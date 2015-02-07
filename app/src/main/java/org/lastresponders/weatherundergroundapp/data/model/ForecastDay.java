package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by stephenjan on 2/5/15.
 */
public class ForecastDay{
    String date;
    String high;
    String low;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "ForecastDay{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                '}';
    }
}
