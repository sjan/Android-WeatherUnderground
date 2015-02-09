package org.lastresponders.weatherundergroundapp.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lastresponders.weatherundergroundapp.data.model.ForecastDay;
import org.lastresponders.weatherundergroundapp.data.model.ForecastHour;
import org.lastresponders.weatherundergroundapp.data.model.Temperature;
import org.lastresponders.weatherundergroundapp.data.model.WeatherCondition;
import org.lastresponders.weatherundergroundapp.data.model.WindCondition;
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
import org.lastresponders.weatherundergroundapp.view.DayListItem;
import org.lastresponders.weatherundergroundapp.view.HourlyListItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stephen jan on 2/5/15.
 */
public class MessageFactory {
    public WeatherCondition weatherCondition(WundergoundCurrentObservation wundergroundWeatherCondition) {
        WeatherCondition ret = new WeatherCondition();
        Log.d("WeatherCondition", "weatherCondition " + wundergroundWeatherCondition.toString());

        ret.setFeelsLike(wundergroundWeatherCondition.getFeelslike_string());
        ret.setWind(wundergroundWeatherCondition.getWindString());
        ret.setWindChill(wundergroundWeatherCondition.getWindchill_string()); //?
        ret.setHeatIndex(wundergroundWeatherCondition.getHeatIndexString());
        ret.setDewPoint(wundergroundWeatherCondition.getDewpointString());
        ret.setTemperature(wundergroundWeatherCondition.getTemperatureString());
        ret.setObservationTime(wundergroundWeatherCondition.getObjservationTimeRFC822());
        ret.setLocalTime(wundergroundWeatherCondition.getLocalTime());
        ret.setWeather(wundergroundWeatherCondition.getWeather());
        return ret;

    }



    public WundergoundCurrentObservation wundergroundCurrentObservation(JSONObject currentObservation) {
        WundergoundCurrentObservation ret = new WundergoundCurrentObservation();

        try {
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
            ret.setObservatoinTime(currentObservation.getString("observation_time"));
            ret.setObjservationTimeRFC822(currentObservation.getString("observation_time_rfc822"));
            currentObservation.getString("observation_epoch");
            ret.setLocalTime(currentObservation.getString("local_time_rfc822"));

            ret.setLocalTimeEpoch(currentObservation.getString("local_epoch"));

            currentObservation.getString("local_tz_short");
            currentObservation.getString("local_tz_long");
            currentObservation.getString("local_tz_offset");
            ret.setWeather(currentObservation.getString("weather"));
            ret.setTemperatureString(currentObservation.getString("temperature_string"));
            currentObservation.getString("temp_f");
            currentObservation.getString("temp_c");
            currentObservation.getString("relative_humidity");
            ret.setWindString(currentObservation.getString("wind_string"));
            currentObservation.getString("wind_dir");
            currentObservation.getString("wind_degrees");
            currentObservation.getString("wind_mph");


            currentObservation.getString("wind_gust_mph");
            currentObservation.getString("wind_kph");
            currentObservation.getString("wind_gust_kph");
            currentObservation.getString("pressure_mb");
            currentObservation.getString("pressure_in");
            currentObservation.getString("pressure_trend");
            ret.setDewpointString(currentObservation.getString("dewpoint_string"));
            currentObservation.getString("dewpoint_f");
            currentObservation.getString("dewpoint_c");

            ret.setHeatIndexString(currentObservation.getString("heat_index_string"));
            currentObservation.getString("heat_index_f");
            currentObservation.getString("heat_index_c");
            ret.setWindchill_string(currentObservation.getString("windchill_string"));
            currentObservation.getString("windchill_f");
            currentObservation.getString("windchill_c");
            ret.setFeelslike_string(currentObservation.getString("feelslike_string"));
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
            e.printStackTrace();
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
            JSONObject object = jsonObject.getJSONObject("FCTTIME");
            String time = object.getString("civil");

            ret.setTime(time);
            ret.setTemp(this.wundergroundMeasurement(jsonObject.getJSONObject("temp")));
            ret.setDewpoint(this.wundergroundMeasurement(jsonObject.getJSONObject("dewpoint")));
            ret.setCondition(jsonObject.getString("condition"));
            ret.setIcon(jsonObject.getString("icon"));
            ret.setIconUrl(jsonObject.getString("icon_url"));
            ret.setFctcode(jsonObject.getString("fctcode"));
            ret.setSky(jsonObject.getString("sky"));
            ret.setWspd(this.wundergroundMeasurement(jsonObject.getJSONObject("wspd")));
            JSONObject windDirection = jsonObject.getJSONObject("wdir");
            ret.setWdir(windDirection.getString("dir"));
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
            e.printStackTrace();
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

    private Temperature temperature(JSONObject temp) throws MessageException {
        Temperature ret = new Temperature();
        try {
            ret.setCelsius(temp.getString("celsius"));
            ret.setFahrenheit(temp.getString("fahrenheit"));
        } catch (JSONException e ) {
            throw new MessageException(e);
        }
        return ret;
    }

    private WundergroungForecastDay wundergroungForecastDay(JSONObject object) throws MessageException {
        WundergroungForecastDay ret = new WundergroungForecastDay();
        try {
            String prettyDate = object.getJSONObject("date").getString("pretty");
            ret.setDate(prettyDate);
            ret.setPeriod(object.getString("period"));
            ret.setHigh(this.temperature(object.getJSONObject("high")));
            ret.setLow(this.temperature(object.getJSONObject("low")));
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
            ret.setMaxWind(this.windCondition(object.getJSONObject("maxwind")));
            ret.setAveWind(this.windCondition(object.getJSONObject("avewind")));
            ret.setAveHumidity(object.getString("avehumidity"));
            ret.setMaxHumidity(object.getString("maxhumidity"));
            ret.setMinHumidity(object.getString("minhumidity"));

        } catch (JSONException e) {
            throw new MessageException(e);
        }


        return ret;
    }


    public WindCondition windCondition(JSONObject object) throws MessageException {
        WindCondition ret  = new WindCondition();
        try {
            ret.setDegrees(object.getString("degrees"));
            ret.setDir(object.getString("dir"));
            ret.setKph(object.getString("kph"));
            ret.setMph(object.getString("mph"));
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
        forecastDay.setAveHumidity(day.getAveHumidity());
        forecastDay.setAveWind(day.getAveWind().getDir());
        forecastDay.setConditions(day.getConditions());
        forecastDay.setTempHigh(day.getHigh().getCelsius());
        forecastDay.setTempLow(day.getLow().getCelsius());

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
        ret.setTime(forecast.getTime());
        ret.setFeelsLike(this.temperature(forecast.getFeelslike()));
        ret.setTemp(this.temperature(forecast.getTemp()));
        ret.setWindDirection(forecast.getWdir());

        return ret;
    }

    private Temperature temperature(WundergroundMeasurement feelslike) {
        Temperature ret = new Temperature();
        ret.setCelsius(feelslike.getMetric());
        ret.setFahrenheit(feelslike.getEnglish());

        return ret;

    }

    public DayListItem dayListItem(ForecastDay day) {
        DayListItem ret = new DayListItem();
        ret.setAveHumidity(day.getAveHumidity());
        ret.setAveWind(day.getAveWind());
        ret.setConditions(day.getConditions());
        ret.setDate(day.getDate());
        ret.setTempHigh(day.getTempHigh());
        ret.setTempLow(day.getTempLow());

        return ret;
    }

    public HourlyListItem hourlyListItem(ForecastHour forecastHour) {
        HourlyListItem item = new HourlyListItem();
        item.setWindDirection(forecastHour.getWindDirection());
        item.setTime(forecastHour.getTime());
        item.setCondition(forecastHour.getCondition());
        item.setFeelsLike(forecastHour.getFeelsLike().getCelsius());
        item.setTemp(forecastHour.getTemp().getCelsius());
        return item;
    }
}
