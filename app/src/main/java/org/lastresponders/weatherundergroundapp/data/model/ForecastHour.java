package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by stephenjan on 2/5/15.
 */
public class ForecastHour {
    //time
    //temp
    //dew point
    //condition
    //icon
    //iconurl
    //fctcode
    //sky
    //windspeed

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    //winddirection
    //snow

    @Override
    public String toString() {
        return "ForecastHour{" +
                "condition='" + condition + '\'' +
                ", time='" + time + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }

    String condition;
    String time;
    String iconUrl;


}
