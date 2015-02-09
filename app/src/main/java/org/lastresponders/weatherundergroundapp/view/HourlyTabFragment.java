package org.lastresponders.weatherundergroundapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.MainActivity;
import org.lastresponders.weatherundergroundapp.R;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;

import java.util.List;

/**
 * Created by sjan on 2/7/2015.
 */
public class HourlyTabFragment extends  Fragment {
    ApplicationState state = ApplicationState.getInstance();
    View v;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("HourlyTabFragment", "onCreateView");
        if (container == null) {
            return null;
        }

        v =  (RelativeLayout)inflater.inflate(R.layout.hourly_forecast_layout, container, false);
        ListView listView = (ListView)v.findViewById(R.id.hourlyListView);
        ListAdapter adapter = new HourlyForecastAdapter(v.getContext(), R.layout.hourly_forecast_list_item);
        listView.setAdapter(adapter);
        this.populate();
        return v;
    }


    public void populate() {
        Log.d("HourlyTabFragment", "populate");
        if(state.getForecastHours() == null) {
            return;
        }
        ListView listView = (ListView)v.findViewById(R.id.hourlyListView);
        HourlyForecastAdapter adapter = (HourlyForecastAdapter)listView.getAdapter();
        adapter.setForecastHourList(state.getForecastHours());

    }
}
