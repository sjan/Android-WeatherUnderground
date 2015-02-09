package org.lastresponders.weatherundergroundapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.service.WeatherService;
import org.lastresponders.weatherundergroundapp.view.OnTaskCompleted;

import java.util.Date;
import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class FetchThreeDayConditions extends AsyncTask<String, Void, List<ForecastDay>> {
    private OnTaskCompleted completionListener;



    public FetchThreeDayConditions(OnTaskCompleted completionListener) {
        this.completionListener = completionListener;
    }

    @Override
    protected List<ForecastDay> doInBackground(String... params) {
        Log.d("FetchThreeDayConditions", "doInBackground");

        if(params!=null && params.length>0) {
            String zipCode = params[0];

            WeatherService service = WeatherService.getInstance();
            List<ForecastDay> list = service.threedayForecast(zipCode);

            return list;
        }

        return null;
    }

    protected void onPostExecute(List<ForecastDay> o){
        Log.d("FetchThreeDayConditions", "onPostExecute");
        ApplicationState state = ApplicationState.getInstance();
        state.setForecaseDays(o);
        completionListener.populateThreeDayForecast();
    }
}
