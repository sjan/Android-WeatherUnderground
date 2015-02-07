package org.lastresponders.weatherundergroundapp.service;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.data.access.*;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WeatherService implements IWeatherService {
    private static WeatherService singleton;

    //access
    private WundergroundAccess access;

    private  WeatherService() {
         access = new WundergroundAccess();
    }

    public static synchronized WeatherService getInstance() {
        if (WeatherService.singleton == null ) {
            WeatherService.singleton = new WeatherService();
        }
        return WeatherService.singleton;
    }

    @Override
    public WeatherCondition currentCondition() {
        return access.conditions();
    }

    @Override
    public List<ForecastHour> hourlyForecast() {
        return access.hourly();
    }

    @Override
    public List<ForecastDay> threedayForecast() {
        return  access.day();
    }
}
