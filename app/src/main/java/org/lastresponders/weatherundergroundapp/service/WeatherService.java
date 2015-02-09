package org.lastresponders.weatherundergroundapp.service;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.data.access.*;
import org.lastresponders.weatherundergroundapp.exception.MessageException;

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
    public WeatherCondition currentCondition(String zipCode) {
        return access.conditions(zipCode);
    }

    @Override
    public List<ForecastHour> hourlyForecast(String zipCode) {
        List<ForecastHour> ret =  access.hourly(zipCode);
        return ret;
    }

    @Override
    public List<ForecastDay> threedayForecast(String zipCode) {
        return  access.day(zipCode);
    }
}
