package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by stephenjan on 2/5/15.
 */
public class ForecastHour {
    String time;
    Temperature temp;
    Temperature  feelsLike;
    String condition;
    String windDirection;

    //Date

    public String getTime() {
        return time;
    }

    public void setTime(String date) {
        this.time = date;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Temperature getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Temperature feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

}
