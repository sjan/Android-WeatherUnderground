package org.lastresponders.weatherundergroundapp.asynctask;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.service.WeatherService;
import org.lastresponders.weatherundergroundapp.view.OnTaskCompleted;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class FetchCurrentCondition extends AsyncTask<String, Void, WeatherCondition> {
    private WeatherService service = WeatherService.getInstance();
    private OnTaskCompleted completionListener;



    public FetchCurrentCondition(OnTaskCompleted completionListener ) {
        this.completionListener = completionListener;
    }

    @Override
    protected WeatherCondition doInBackground(String... params) {
        Log.d("FetchCurrentCondition", "doInBackground");
        if(params!=null && params.length>0) {
            String zipCode = params[0];
            WeatherCondition condition = service.currentCondition(zipCode);
            return condition;
        }

        return null;
    }

    protected void onPostExecute(WeatherCondition o){
        //populate weather conition into weather condition tab
        ApplicationState state = ApplicationState.getInstance();
        state.setWeatherCondition(o);
        completionListener.populateCurrentConditions();
    }
}
