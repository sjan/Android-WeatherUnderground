package org.lastresponders.weatherundergroundapp;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;

import java.util.Date;
import java.util.List;

/**
 * Created by sjan on 2/8/2015.
 */
public class ApplicationState {
    Date refreshTime;
    Boolean refresh = false;
    String zipCode = null;
    WeatherCondition weatherCondition = null;
    List<ForecastDay> forecaseDays = null;
    List<ForecastHour> forecastHours = null;
    Date lastUpdate = null;

    public Date getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public List<ForecastDay> getForecaseDays() {
        return forecaseDays;
    }

    public void setForecaseDays(List<ForecastDay> forecaseDays) {
        this.forecaseDays = forecaseDays;
    }

    public List<ForecastHour> getForecastHours() {
        return forecastHours;
    }

    public void setForecastHours(List<ForecastHour> forecastHours) {
        this.forecastHours = forecastHours;
    }

    private static ApplicationState singleton = null;

    public static synchronized ApplicationState  getInstance() {
        if(singleton == null) {
            singleton = new ApplicationState();
        }
        return singleton;
    }

    private ApplicationState() {

    }
}
