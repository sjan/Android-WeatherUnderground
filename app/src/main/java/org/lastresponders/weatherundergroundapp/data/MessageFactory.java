package org.lastresponders.weatherundergroundapp.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.SimpleForecast;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergoundCurrentObservation;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundConditionsResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundForecast;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundForecastResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundHourlyForecast;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundHourlyResponse;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroundMeasurement;
import org.lastresponders.weatherundergroundapp.data.model.wunderground.WundergroungForecastDay;
import org.lastresponders.weatherundergroundapp.exception.MessageException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stephen jan on 2/5/15.
 */
public class MessageFactory {
    public WeatherCondition weatherCondition(WundergoundCurrentObservation wundergroundWeatherCondition) {
        WeatherCondition ret = new WeatherCondition();

        Log.d("WeatherCondition", "weatherCondition");

        ret.setFeelsLike(wundergroundWeatherCondition.getFeelslike_c());
        ret.setIcon(wundergroundWeatherCondition.getIcon());
        ret.setLocation(wundergroundWeatherCondition.getObservationLocation());
        ret.setTemperature(wundergroundWeatherCondition.getTemperatureString());
        ret.setWind(wundergroundWeatherCondition.getWindDir());
        return ret;

    }



    public WundergoundCurrentObservation wundergroundCurrentObservation(JSONObject currentObservation) {
        WundergoundCurrentObservation ret = new WundergoundCurrentObservation();

        try {
            /*  ret.setFeelsLike(wundergroundWeatherCondition.getFeelslike_c());
        ret.setIcon(wundergroundWeatherCondition.getIcon());
        ret.setLocation(wundergroundWeatherCondition.getObservationLocation());
        ret.setTemperature(wundergroundWeatherCondition.getTemperatureString());
        ret.setWind(wundergroundWeatherCondition.getWindDir());*/
            ret.setFeelslike_c(currentObservation.getString("feelslike_c"));
            ret.setIcon(currentObservation.getString("icon"));
            ret.setObservationLocation(currentObservation.getString("observation_location"));
            ret.setTemperatureString(currentObservation.getString("temperature_string"));
            ret.setWindDir(currentObservation.getString("wind_dir"));
            currentObservation.getJSONObject("image");
            currentObservation.getJSONObject("display_location");
            currentObservation.getJSONObject("observation_location");
            currentObservation.getJSONObject("estimated");
       //     ret.setStationId(currentObservation.getString("station_id"));
            currentObservation.getString("observation_time");
            currentObservation.getString("observation_time_rfc822");
            currentObservation.getString("observation_epoch");
            currentObservation.getString("local_time_rfc822");

            currentObservation.getString("local_epoch");

            currentObservation.getString("local_tz_short");
            currentObservation.getString("local_tz_long");
            currentObservation.getString("local_tz_offset");
            currentObservation.getString("weather");
            currentObservation.getString("temperature_string");
            currentObservation.getString("temp_f");
            currentObservation.getString("temp_c");
            currentObservation.getString("relative_humidity");
            currentObservation.getString("wind_string");
            currentObservation.getString("wind_dir");
            currentObservation.getString("wind_degrees");
            currentObservation.getString("wind_mph");


            currentObservation.getString("wind_gust_mph");
            currentObservation.getString("wind_kph");
            currentObservation.getString("wind_gust_kph");
            currentObservation.getString("pressure_mb");
            currentObservation.getString("pressure_in");
            currentObservation.getString("pressure_trend");
            currentObservation.getString("dewpoint_string");
            currentObservation.getString("dewpoint_f");
            currentObservation.getString("dewpoint_c");

            currentObservation.getString("heat_index_string");
            currentObservation.getString("heat_index_f");
            currentObservation.getString("heat_index_c");
            currentObservation.getString("windchill_string");
            currentObservation.getString("windchill_f");
            currentObservation.getString("windchill_c");
            currentObservation.getString("feelslike_string");
            currentObservation.getString("feelslike_f");
            currentObservation.getString("feelslike_c");

            currentObservation.getString("visibility_mi");
            currentObservation.getString("visibility_km");
            currentObservation.getString("solarradiation");
            currentObservation.getString("UV");
            currentObservation.getString("precip_1hr_string");
            //currentObservation.getString("precip_1hr_in");
//            currentObservation.getString("precip_1hr_metric");
//            currentObservation.getString("precip_today_string");
//            currentObservation.getString("precip_today_in");
//            currentObservation.getString("precip_today_metric");

            currentObservation.getString("icon");
            currentObservation.getString("icon_url");
            currentObservation.getString("forecast_url");
            currentObservation.getString("history_url");
            currentObservation.getString("ob_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public WundergroundConditionsResponse wundergroundConditionResponse(JSONObject jsonObject) throws JSONException {
        Log.d("wundergroundConditionResponse","wundergroundConditionResponse " + jsonObject.toString());
        WundergroundConditionsResponse ret = new WundergroundConditionsResponse();

        JSONObject response =  jsonObject.getJSONObject("response");
        ret.setResponseBlock(response);

        JSONObject currentObservationJson =  jsonObject.getJSONObject("current_observation");

        WundergoundCurrentObservation currentObservation=  this.wundergroundCurrentObservation(currentObservationJson);

        ret.setCurrentObservation(currentObservation);
        return ret;

    }

    private WundergoundCurrentObservation currentObservation(JSONObject currentObservationJson) {
        WundergoundCurrentObservation ret = new WundergoundCurrentObservation();


        return ret;
    }

    public WundergroundHourlyResponse wundergroundHourlyResponse(JSONObject response) throws MessageException {
        WundergroundHourlyResponse ret = new WundergroundHourlyResponse();
        try {
            response.getJSONObject("response");
            ret.setResponseBlock(ret.toString());

            JSONArray array = response.getJSONArray("hourly_forecast");

            List<WundergroundHourlyForecast> hourlyForecastList = this.wundergroundHourlyForecastList(array);
            ret.setList(hourlyForecastList);



        } catch (JSONException e) {
            throw new MessageException(e);
        }

        return ret;
    }

    public List<WundergroundHourlyForecast> wundergroundHourlyForecastList(JSONArray wundergroundHourlyArray) throws MessageException {
        int length = wundergroundHourlyArray.length();
        List <WundergroundHourlyForecast> list = new ArrayList<WundergroundHourlyForecast>();
        try {
            for (int i = 0; i < length; i++) {
                WundergroundHourlyForecast wundergroundHourlyForecast = this.wundergroundHourlyForecast(wundergroundHourlyArray.getJSONObject(i));
                list.add(wundergroundHourlyForecast);
            }
        } catch (JSONException e){
            throw new MessageException(e);
        }
        return list;
    }

    private WundergroundMeasurement wundergroundMeasurement (JSONObject object) throws MessageException {
        WundergroundMeasurement measurement = new WundergroundMeasurement();
        try {
            measurement.setMetric(object.getString("metric"));
            measurement.setEnglish(object.getString("english"));
        } catch (JSONException e) {
            throw new MessageException( e);
        }

        return measurement;
    }

    private WundergroundHourlyForecast wundergroundHourlyForecast(JSONObject jsonObject) throws MessageException {
        WundergroundHourlyForecast ret = new WundergroundHourlyForecast();
        try {
            ret.setFCTIME(jsonObject.getString("FCTTIME"));
            ret.setTemp(this.wundergroundMeasurement(jsonObject.getJSONObject("temp")));
            ret.setDewpoint(this.wundergroundMeasurement(jsonObject.getJSONObject("dewpoint")));
            ret.setCondition(jsonObject.getString("condition"));
            ret.setIcon(jsonObject.getString("icon"));
            ret.setIconUrl(jsonObject.getString("icon_url"));
            ret.setFctcode(jsonObject.getString("fctcode"));
            ret.setSky(jsonObject.getString("sky"));
            ret.setWspd(this.wundergroundMeasurement(jsonObject.getJSONObject("wspd")));
            ret.setWdir(jsonObject.getString("wdir"));
            ret.setWx(jsonObject.getString("wx"));
            ret.setUxi(jsonObject.getString("uvi"));
            ret.setHumidity(jsonObject.getString("humidity"));
            ret.setWindchill(this.wundergroundMeasurement(jsonObject.getJSONObject("windchill")));
            ret.setHeatindex(this.wundergroundMeasurement(jsonObject.getJSONObject("heatindex")));
            ret.setFeelslike(this.wundergroundMeasurement(jsonObject.getJSONObject("feelslike")));
            ret.setQpf(this.wundergroundMeasurement(jsonObject.getJSONObject("qpf")));
            ret.setSnow(this.wundergroundMeasurement(jsonObject.getJSONObject("snow")));
            ret.setPop(jsonObject.getString("pop"));
            ret.setMslp(this.wundergroundMeasurement(jsonObject.getJSONObject("mslp")));
        } catch (JSONException e) {
            e.printStackTrace();
            throw new MessageException(e);
        }
        return ret;
    }

    public WundergroundForecastResponse wundergroundForecastResponse(JSONObject response) throws MessageException{
        WundergroundForecastResponse ret = new WundergroundForecastResponse();

        try {

            JSONObject object = response.getJSONObject("response");
            ret.setResponseBlock(object.toString());

            object = response.getJSONObject("forecast");
            WundergroundForecast wundergroundForecast = this.wundergroundForecast(object);

            ret.setForecast(wundergroundForecast);

        } catch (JSONException e) {
            throw new MessageException(e);
        }

        return ret;
    }

    private WundergroundForecast wundergroundForecast(JSONObject object)  throws MessageException {
        WundergroundForecast ret = new WundergroundForecast();
        try {
            JSONObject forecast = object.getJSONObject("txt_forecast");
            ret.setTxtForecast(forecast.toString());

            forecast = object.getJSONObject("simpleforecast");
            ret.setSimpleForecast(this.simpleForecast(forecast));
        } catch (JSONException e) {
            e.printStackTrace();
            throw new MessageException(e);
        }
        return ret;

    }

    private SimpleForecast simpleForecast(JSONObject forecast) throws MessageException {
        SimpleForecast ret = new SimpleForecast();
      try {


          List<WundergroungForecastDay> list = new ArrayList<WundergroungForecastDay>();
          JSONArray array = forecast.getJSONArray("forecastday");
          for(int i=0;i<array.length();i++) {
              JSONObject object = array.getJSONObject(i);
                list.add(this.wundergroungForecastDay(object));
          }

          ret.setDayList(list);

      } catch (JSONException e) {
          e.printStackTrace();
          throw new MessageException(e);
      }

        return ret;
    }

    private WundergroungForecastDay wundergroungForecastDay(JSONObject object) throws MessageException {
        WundergroungForecastDay ret = new WundergroungForecastDay();
        try {
            ret.setDate(object.getJSONObject("date").toString());
            ret.setPeriod(object.getString("period"));
            ret.setHigh(object.getString("high"));
            ret.setLow(object.getString("low"));
            ret.setConditions(object.getString("conditions"));
            ret.setIcon(object.getString("icon"));
            ret.setIconUrl(object.getString("icon_url"));
            ret.setPop(object.getString("pop"));
            ret.setQpfAllDay(object.getString("qpf_allday"));
            ret.setQpfDay(object.getString("qpf_day"));
            ret.setQpfNight(object.getString("qpf_night"));
            ret.setSnowAllDay(object.getString("snow_allday"));
            ret.setSnowDay(object.getString("snow_day"));
            ret.setSnowNight(object.getString("snow_night"));
            ret.setMaxWind(object.getString("maxwind"));
            ret.setAveWind(object.getString("avewind"));
            ret.setAveHumidity(object.getString("avehumidity"));
            ret.setMaxHumidity(object.getString("maxhumidity"));
            ret.setMinHumidity(object.getString("minhumidity"));

        } catch (JSONException e) {
            throw new MessageException(e);
        }


        return ret;
    }


    public List<ForecastDay> forecastDayList(List<WundergroungForecastDay> list) {
        List<ForecastDay> ret = new ArrayList<ForecastDay>();
        Iterator<WundergroungForecastDay> i = list.iterator();
        while(i.hasNext()) {
            WundergroungForecastDay day = i.next();
            ForecastDay forecastDay = this.forecastDay(day);
            ret.add(forecastDay);

            Log.d("MessageFactory",forecastDay.toString());
        }

        return ret;
    }

    private ForecastDay forecastDay(WundergroungForecastDay day) {
        ForecastDay forecastDay = new ForecastDay();

        forecastDay.setDate(day.getDate());
        forecastDay.setHigh(  day.getHigh());
        forecastDay.setLow(  day.getHigh());
        return forecastDay;
    }

    public List<ForecastHour> hourlyForecastList(List<WundergroundHourlyForecast> list) {
        List<ForecastHour> ret = new ArrayList<ForecastHour>();

        Iterator <WundergroundHourlyForecast> iterator = list.iterator();
        while(iterator.hasNext()) {
            WundergroundHourlyForecast forecast = iterator.next();
            ForecastHour forecastHour = this.forecastHour(forecast);
            ret.add(forecastHour);

        }

        return ret;
    }

    private ForecastHour forecastHour(WundergroundHourlyForecast forecast) {
        ForecastHour ret = new ForecastHour();
        ret.setCondition(forecast.getCondition());
        ret.setTime(forecast.getFCTIME());
        ret.setIconUrl(forecast.getIconUrl());

        return ret;
    }
}
