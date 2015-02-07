package org.lastresponders.weatherundergroundapp.data.model.wunderground;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class SimpleForecast {
    List<WundergroungForecastDay> dayList;


    public List<WundergroungForecastDay> getDayList() {
        return dayList;
    }

    public void setDayList(List<WundergroungForecastDay> dayList) {
        this.dayList = dayList;
    }


}
