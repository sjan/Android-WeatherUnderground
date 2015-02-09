package org.lastresponders.weatherundergroundapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.R;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;

/**
 * Created by sjan on 2/7/2015.
 */
public class CurrentTabFragment extends Fragment {
    View v=null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("CurrentTabFragment", "onCreateView");

        if (container == null) {
            return null;
        }

        v = (RelativeLayout)inflater.inflate(R.layout.current_conditions_layout, container, false);

        if(ApplicationState.getInstance().getWeatherCondition() != null ) {
            this.populate();
        }

        return v;
    }



    public void populate() {
        WeatherCondition condition = ApplicationState.getInstance().getWeatherCondition();
        if(condition != null ) {
            Log.d("CurrentTabFragment", "populate");

            TextView textView = (TextView) v.findViewById(R.id.textViewWeather);
            textView.setText("Weather: " + condition.getWeather());

            textView = (TextView) v.findViewById(R.id.textViewTemperature);
            textView.setText("Temp: " + condition.getTemperature());
            textView = (TextView) v.findViewById(R.id.textViewFeelsLike);
            textView.setText("Feels like: " + condition.getFeelsLike());

            textView = (TextView) v.findViewById(R.id.textViewTime);
            textView.setText("Time: " + condition.getLocalTime());


            textView = (TextView) v.findViewById(R.id.textViewWind);
            textView.setText("Wind: " + condition.getWind());
            textView = (TextView) v.findViewById(R.id.textViewWindChill);
            textView.setText("Wind chill: " + condition.getWindChill());

            textView = (TextView) v.findViewById(R.id.textViewDewpoint);
            textView.setText("Dew Point: " + condition.getDewPoint());
            textView = (TextView) v.findViewById(R.id.textViewObservationTime);
            textView.setText("Observation Time: " + condition.getObservationTime());
            textView = (TextView) v.findViewById(R.id.textViewHeatIndex);
            textView.setText("Heat Index: " + condition.getHeatIndex());
        }
    }
}
