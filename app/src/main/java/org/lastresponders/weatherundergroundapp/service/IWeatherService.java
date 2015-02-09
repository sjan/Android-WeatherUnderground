package org.lastresponders.weatherundergroundapp.service;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public interface IWeatherService {
    public WeatherCondition currentCondition(String zip);
    public List<ForecastHour> hourlyForecast(String zip);
    public List<ForecastDay> threedayForecast(String zip);
}
