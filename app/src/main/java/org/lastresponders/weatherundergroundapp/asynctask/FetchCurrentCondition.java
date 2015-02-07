package org.lastresponders.weatherundergroundapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.service.WeatherService;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class FetchCurrentCondition extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... params) {

        Log.d("FetchCurrentCondition", "do in background");


        WeatherService service = WeatherService.getInstance();
        WeatherCondition condition = service.currentCondition();

        return null;
    }
}
