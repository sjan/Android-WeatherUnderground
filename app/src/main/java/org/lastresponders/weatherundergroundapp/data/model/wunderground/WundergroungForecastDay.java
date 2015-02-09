package org.lastresponders.weatherundergroundapp.data.model.wunderground;

import org.lastresponders.weatherundergroundapp.data.model.Temperature;
import org.lastresponders.weatherundergroundapp.data.model.WindCondition;

/**
 * Created by stephenjan on 2/6/15.
 */
public class WundergroungForecastDay {
    String date;
    Temperature high;
    Temperature low;
    String conditions;
    String icon;
    String iconUrl;
    String qpfAllDay;
    String qpfDay;
    String period;
    String pop;
    String qpfNight;
    String snowAllDay;
    String snowDay;
    String snowNight;
    WindCondition maxWind;
    WindCondition aveWind;
    String aveHumidity;
    String maxHumidity;

    public String getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(String minHumidity) {
        this.minHumidity = minHumidity;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getQpfNight() {
        return qpfNight;
    }

    public void setQpfNight(String qpfNight) {
        this.qpfNight = qpfNight;
    }

    public String getSnowAllDay() {
        return snowAllDay;
    }

    public void setSnowAllDay(String snowAllday) {
        this.snowAllDay = snowAllday;
    }

    public String getSnowDay() {
        return snowDay;
    }

    public void setSnowDay(String snowDay) {
        this.snowDay = snowDay;
    }

    public String getSnowNight() {
        return snowNight;
    }

    public void setSnowNight(String snowNight) {
        this.snowNight = snowNight;
    }

    public String getAveHumidity() {
        return aveHumidity;
    }

    public void setAveHumidity(String aveHumidity) {
        this.aveHumidity = aveHumidity;
    }

    public String getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(String maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    String minHumidity;




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getHigh() {
        return high;
    }

    public void setHigh(Temperature high) {
        this.high = high;
    }

    public Temperature getLow() {
        return low;
    }

    public void setLow(Temperature low) {
        this.low = low;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getQpfAllDay() {
        return qpfAllDay;
    }

    public void setQpfAllDay(String qpfAllDay) {
        this.qpfAllDay = qpfAllDay;
    }

    public String getQpfDay() {
        return qpfDay;
    }

    public void setQpfDay(String qpfDay) {
        this.qpfDay = qpfDay;
    }

    public WindCondition getMaxWind() {
        return maxWind;
    }

    public void setMaxWind(WindCondition maxWind) {
        this.maxWind = maxWind;
    }

    public WindCondition getAveWind() {
        return aveWind;
    }

    public void setAveWind(WindCondition aveWind) {
        this.aveWind = aveWind;
    }




}
