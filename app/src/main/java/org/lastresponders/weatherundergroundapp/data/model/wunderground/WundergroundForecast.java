package org.lastresponders.weatherundergroundapp.data.model.wunderground;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WundergroundForecast {
    public String getTxtForecast() {
        return txtForecast;
    }

    public void setTxtForecast(String txtForcast) {
        this.txtForecast = txtForcast;
    }

    public SimpleForecast getSimpleForecast() {
        return simpleForecast;
    }

    public void setSimpleForecast(SimpleForecast simpleForecast) {
        this.simpleForecast = simpleForecast;
    }

    String txtForecast;

    SimpleForecast simpleForecast;
}
