package org.lastresponders.weatherundergroundapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.lastresponders.weatherundergroundapp.ApplicationState;
import org.lastresponders.weatherundergroundapp.R;

/**
 * Created by sjan on 2/7/2015.
 */
public class ThreeDayTabFragment extends Fragment {
    View v;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ThreeDayTabFragment","onCreateView");
        if (container == null) {
            return null;
        }

         v = (RelativeLayout)inflater.inflate(R.layout.threeday_forecast_layout, container, false);
        ListView listView = (ListView)v.findViewById(R.id.threeDayListView);

        ListAdapter adapter = new ThreeDayForecastAdapter(v.getContext(), R.layout.threeday_forecast_list_item);
        listView.setAdapter(adapter);


        ApplicationState state = ApplicationState.getInstance();

        if(state.getForecaseDays() != null) {
            this.populate();

        }
        return v;
    }

    public void populate() {
        Log.d("ThreeDayTabFragment", "populate");
        ApplicationState state = ApplicationState.getInstance();
        ListView listView = (ListView)v.findViewById(R.id.threeDayListView);
        ThreeDayForecastAdapter adapter = (ThreeDayForecastAdapter )listView.getAdapter();
        adapter.setForecastDayList(state.getForecaseDays());
    }
}
