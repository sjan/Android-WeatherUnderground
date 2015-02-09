package org.lastresponders.weatherundergroundapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.service.WeatherService;
import org.lastresponders.weatherundergroundapp.view.OnTaskCompleted;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class FetchHourlyConditions extends AsyncTask<String, Void,  List<ForecastHour>> {
    private OnTaskCompleted completionListener;

    public FetchHourlyConditions(OnTaskCompleted completionListener ) {
        this.completionListener = completionListener;
    }


    @Override
    protected  List<ForecastHour> doInBackground(String... params) {
        WeatherService service = WeatherService.getInstance();

        Log.d("FetchHourlyConditions", "do in background");
        if(params!=null && params.length>0) {
            String zipCode = params[0];

            List<ForecastHour> list = service.hourlyForecast(zipCode);

            return list;
        }
        return null;
    }

    protected void onPostExecute(List<ForecastHour> o){
        ApplicationState state = ApplicationState.getInstance();
        state.setForecastHours(o);
        completionListener.populateHourlyForecast();
    }
}
