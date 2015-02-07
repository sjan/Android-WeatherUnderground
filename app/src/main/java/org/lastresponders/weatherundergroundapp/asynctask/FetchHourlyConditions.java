package org.lastresponders.weatherundergroundapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.service.WeatherService;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class FetchHourlyConditions extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... params) {

        Log.d("FetchHourlyConditions", "do in background");


        WeatherService service = WeatherService.getInstance();
        List<ForecastHour> list = service.hourlyForecast();

        Iterator<ForecastHour> iterator = list.iterator();

        while(iterator.hasNext()) {
            ForecastHour foreCastHour = iterator.next();
            Log.d("FetchHourlyConditions",foreCastHour.toString());
        }

        return null;
    }
}
