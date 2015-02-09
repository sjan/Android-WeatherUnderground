package org.lastresponders.weatherundergroundapp.view;

/**
 * Created by sjan on 2/8/2015.
 */
public class HourlyListItem {
    String time;
    String temp;
    String feelsLike;
    String condition;
    String windDirection;

    //Date

    public String getTime() {
        return time;
    }

    public void setTime(String t) {
        this.time= t;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
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
