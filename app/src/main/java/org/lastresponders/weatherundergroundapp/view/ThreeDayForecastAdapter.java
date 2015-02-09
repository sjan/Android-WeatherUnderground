package org.lastresponders.weatherundergroundapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

import org.lastresponders.weatherundergroundapp.R;
import org.lastresponders.weatherundergroundapp.data.MessageFactory;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
/**
 * Created by sjan on 2/8/2015.
 */
public class ThreeDayForecastAdapter extends ArrayAdapter<DayListItem> {
    MessageFactory messagefactory = new MessageFactory();
    List<ForecastDay> forecastDayList = null;

    public List<ForecastDay> getForecastDayList() {
        return forecastDayList;
    }

    public void setForecastDayList(List<ForecastDay> forecastList) {
        this.forecastDayList = forecastList;
        this.notifyDataSetChanged();
    }



    public ThreeDayForecastAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public int getCount() {
        if(forecastDayList == null)
            return 0;
        else
            return forecastDayList.size();
    }

    @Override
    public DayListItem getItem(int position) {
        if(forecastDayList == null) {
            return null;
        }
        ForecastDay day =  forecastDayList.get(position);
        DayListItem ret = messagefactory.dayListItem(day);

        return (ret);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.threeday_forecast_list_item, null);

        }

        DayListItem p = getItem(position);

        if (p != null) {

            TextView tt1 = (TextView) v.findViewById(R.id.textViewDate);
            tt1.setText("Forecast date: " + p.getDate());
            tt1  = (TextView) v.findViewById(R.id.textViewHigh);
            tt1.setText("High: " + p.getTempHigh() + " C"  );
            tt1 = (TextView) v.findViewById(R.id.textViewLow);
            tt1.setText("Low: " + p.getTempLow() + " C");
            tt1 = (TextView) v.findViewById(R.id.textViewConditions);
            tt1.setText("Condition: " + p.getConditions());
            tt1 = (TextView) v.findViewById(R.id.textViewHumidity);
            tt1.setText("Humidity: " + p.getAveHumidity() + "%");
            tt1 = (TextView) v.findViewById(R.id.textViewWind);
            tt1.setText("Wind: "  + p.getAveWind());

        }

        return v;
    }

    public long getItemId(int position) {
        return 0;
    }

}
