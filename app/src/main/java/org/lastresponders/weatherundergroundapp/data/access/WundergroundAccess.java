package org.lastresponders.weatherundergroundapp.data.access;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.lastresponders.weatherundergroundapp.data.MessageFactory;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundConditionsResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundForecastResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundHourlyResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroungForecastDay;
import org.lastresponders.weatherundergroundapp.exception.MessageException;
import org.lastresponders.weatherundergroundapp.exception.NetworkException;

import java.util.List;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WundergroundAccess {
    private IWundergroundClient client = new WundergroundClientMock();
    private MessageFactory messageFactory = new MessageFactory();

    public WundergroundAccess() {

    }

    public WeatherCondition conditions() {
        Log.d("WundergroundAccess", "zipcode:");

        WeatherCondition ret = null;
        JSONObject jsonObject = null;

        WundergroundConditionsResponse wundergroundConditionsResponse = null;
        try {
            String response = client.conditions("10024");
            jsonObject  = new JSONObject(response);
            wundergroundConditionsResponse = messageFactory.wundergroundConditionResponse(jsonObject);
            ret =  messageFactory.weatherCondition(wundergroundConditionsResponse.getCurrentObservation());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        } catch (NetworkException e) {
            e.printStackTrace();
        }

        return ret;
    }


    public List<ForecastHour> hourly() {
        List<ForecastHour>  ret = null;
        try {
        String response = client.hourly("10024");

            JSONObject jsonObject = null;

            jsonObject  = new JSONObject(response);
            WundergroundHourlyResponse wundergroundHourlyResponse = messageFactory.wundergroundHourlyResponse(jsonObject);


            ret =  messageFactory.hourlyForecastList(wundergroundHourlyResponse.getList());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        } catch (NetworkException e) {
            e.printStackTrace();
        }




        return ret;
    }


    public List<ForecastDay> day() {

        Log.d("WundergroundAccess", "zipcode:");

        List<ForecastDay>  ret = null;
        JSONObject jsonObject = null;

        WundergroundConditionsResponse wundergroundConditionsResponse = null;
        try {
            String response = client.day("10024");
            Log.d("WundergroundAccess:day",response);
            jsonObject  = new JSONObject(response);
            WundergroundForecastResponse wundergroundForecastResponse = messageFactory.wundergroundForecastResponse(jsonObject);

            List<WundergroungForecastDay> list = wundergroundForecastResponse.getForecast().getSimpleForecast().getDayList();
            ret  =  messageFactory.forecastDayList(list);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        } catch (NetworkException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
