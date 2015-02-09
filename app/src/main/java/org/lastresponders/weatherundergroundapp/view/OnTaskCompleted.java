package org.lastresponders.weatherundergroundapp.view;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;

import java.util.List;

/**
 * Created by sjan on 2/7/2015.
 */
public interface OnTaskCompleted {
    public void populateHourlyForecast();
    public void populateThreeDayForecast();
    public void populateCurrentConditions();
}
