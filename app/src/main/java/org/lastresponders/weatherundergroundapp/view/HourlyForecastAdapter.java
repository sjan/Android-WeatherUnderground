package org.lastresponders.weatherundergroundapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.lastresponders.weatherundergroundapp.R;
import org.lastresponders.weatherundergroundapp.data.MessageFactory;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;

import java.util.List;

/**
 * Created by sjan on 2/8/2015.
 */
public class HourlyForecastAdapter extends ArrayAdapter<HourlyListItem> {
    List<ForecastHour> forecastHourList = null;
    MessageFactory messageFactory = new MessageFactory();

    public List<ForecastHour> getForecastHourList() {
        return forecastHourList;
    }

    public void setForecastHourList(List<ForecastHour> forecastHourList) {
        this.forecastHourList = forecastHourList;
        this.notifyDataSetChanged();
    }



    public HourlyForecastAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public HourlyForecastAdapter(Context context, int resource,  List<ForecastHour> forecastHourList) {
        super(context, resource);
        this.setForecastHourList(forecastHourList);
    }

    @Override
    public int getCount() {
        if(forecastHourList == null)
            return 0;
        else
            return forecastHourList.size();
    }

    @Override
    public HourlyListItem getItem(int position) {
        if(forecastHourList == null || position > forecastHourList.size()) {
            return null;
        }
        return (messageFactory.hourlyListItem(forecastHourList.get(position)));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.hourly_forecast_list_item, null);

        }

        HourlyListItem p = getItem(position);

        if (p != null) {

            TextView tt1 = (TextView) v.findViewById(R.id.time);
            TextView tt2 = (TextView) v.findViewById(R.id.temp);
            TextView tt3 = (TextView) v.findViewById(R.id.feelsLike);
            TextView tt4 = (TextView) v.findViewById(R.id.condition);
            TextView tt5 = (TextView) v.findViewById(R.id.windDirection);

            if (tt1 != null) {
                tt1.setText(p.getTime());
            }
            if (tt2 != null) {
                tt2.setText( p.getTemp() + " C");
            }
            if (tt3 != null) {
                tt3.setText(p.getFeelsLike() + " C");
            }
            if (tt4 != null) {
                tt4.setText(p.getCondition());
            }
            if (tt5 != null) {
                tt5.setText(p.getWindDirection());
            }
        }
        return v;
    }

    public long getItemId(int position) {
        return 0;
    }

}
