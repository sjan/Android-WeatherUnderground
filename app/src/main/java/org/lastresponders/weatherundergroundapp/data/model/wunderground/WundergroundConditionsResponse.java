package org.lastresponders.weatherundergroundapp.data.model.wunderground;

import org.json.JSONObject;

/**
 * Created by stephenjan on 2/5/15.
 * {
 "response": {
 "version":"0.1",
 "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
 "features": {
 "conditions": 1
 }
 }
 ,	"current_observation": {
 "image": {
 "url":"http://icons.wxug.com/graphics/wu2/logo_130x80.png",
 "title":"Weather Underground",
 "link":"http://www.wunderground.com"
 },
 "display_location": {
 "full":"New York, NY",
 "city":"New York",
 "state":"NY",
 "state_name":"New York",
 "country":"US",
 "country_iso3166":"US",
 "zip":"10024",
 "magic":"1",
 "wmo":"99999",
 "latitude":"40.78629303",
 "longitude":"-73.97723389",
 "elevation":"37.00000000"
 },
 "observation_location": {
 "full":"Upper West Side, New York, New York",
 "city":"Upper West Side, New York",
 "state":"New York",
 "country":"US",
 "country_iso3166":"US",
 "latitude":"40.791683",
 "longitude":"-73.970772",
 "elevation":"154 ft"
 },
 "estimated": {
 },
 "station_id":"KNYNEWYO92",
 "observation_time":"Last Updated on February 5, 7:00 PM EST",
 "observation_time_rfc822":"Thu, 05 Feb 2015 19:00:01 -0500",
 "observation_epoch":"1423180801",
 "local_time_rfc822":"Thu, 05 Feb 2015 19:04:39 -0500",
 "local_epoch":"1423181079",
 "local_tz_short":"EST",
 "local_tz_long":"America/New_York",
 "local_tz_offset":"-0500",
 "weather":"Clear",
 "temperature_string":"21.9 F (-5.6 C)",
 "temp_f":21.9,
 "temp_c":-5.6,
 "relative_humidity":"34%",
 "wind_string":"From the North at 13.0 MPH Gusting to 26.0 MPH",
 "wind_dir":"North",
 "wind_degrees":360,
 "wind_mph":13.0,
 "wind_gust_mph":"26.0",
 "wind_kph":20.9,
 "wind_gust_kph":"41.8",
 "pressure_mb":"1021",
 "pressure_in":"30.15",
 "pressure_trend":"+",
 "dewpoint_string":"-2 F (-19 C)",
 "dewpoint_f":-2,
 "dewpoint_c":-19,
 "heat_index_string":"NA",
 "heat_index_f":"NA",
 "heat_index_c":"NA",
 "windchill_string":"10 F (-12 C)",
 "windchill_f":"10",
 "windchill_c":"-12",
 "feelslike_string":"10 F (-12 C)",
 "feelslike_f":"10",
 "feelslike_c":"-12",
 "visibility_mi":"10.0",
 "visibility_km":"16.1",
 "solarradiation":"--",
 "UV":"0","precip_1hr_string":"0.00 in ( 0 mm)",
 "precip_1hr_in":"0.00",
 "precip_1hr_metric":" 0",
 "precip_today_string":"0.00 in (0 mm)",
 "precip_today_in":"0.00",
 "precip_today_metric":"0",
 "icon":"clear",
 "icon_url":"http://icons.wxug.com/i/c/k/nt_clear.gif",
 "forecast_url":"http://www.wunderground.com/US/NY/New_York.html",
 "history_url":"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=KNYNEWYO92",
 "ob_url":"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=40.791683,-73.970772",
 "nowcast":""
 }
 }
 */
public class WundergroundConditionsResponse {
    JSONObject responseBlock;
    WundergoundCurrentObservation currentObservation;


    public JSONObject getResponseBlock() {
        return responseBlock;
    }

    public void setResponseBlock(JSONObject responseBlock) {
        this.responseBlock = responseBlock;
    }


    public WundergoundCurrentObservation getCurrentObservation() {
        return currentObservation;
   }

   public void setCurrentObservation(WundergoundCurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
   }



}

