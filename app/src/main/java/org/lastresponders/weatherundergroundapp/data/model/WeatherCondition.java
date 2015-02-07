package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WeatherCondition {
    //temperature
    //Wind
    //Feels Like
    //ICON
    //observation location

    @Override
    public String toString() {
        return "WeatherCondition{" +
                "temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", feelsLike='" + feelsLike + '\'' +
                ", icon='" + icon + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String wind;
    String feelsLike;
    String icon;
    String location;

}
