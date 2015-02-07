package org.lastresponders.weatherundergroundapp.data.model.wunderground;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WundergroundMeasurement {
    String metric;
    String english;

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
