package org.lastresponders.weatherundergroundapp.data.model.wunderground;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WundergroundForecastResponse {
    public String getResponseBlock() {
        return responseBlock;
    }

    public void setResponseBlock(String responseBlock) {
        this.responseBlock = responseBlock;
    }

    public WundergroundForecast getForecast() {
        return forecast;
    }

    public void setForecast(WundergroundForecast forecast) {
        this.forecast = forecast;
    }

    //response
    private String responseBlock;

    private WundergroundForecast forecast;



}
