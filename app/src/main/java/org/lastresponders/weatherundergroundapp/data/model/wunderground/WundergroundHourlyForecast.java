package org.lastresponders.weatherundergroundapp.data.model.wunderground;

/**
 * Created by stephenjan on 2/5/15.
*/


public class WundergroundHourlyForecast {
    private String FCTIME;
    private WundergroundMeasurement temp;
    private WundergroundMeasurement dewpoint;
    private String condition;
    private String icon;
    private String iconUrl;
    private String fctcode;
    private String sky;
    private WundergroundMeasurement  wspd;
    private String wdir;
    private String wx;
    private String uxi;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
    private String humidity;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    private WundergroundMeasurement windchill;
    private WundergroundMeasurement heatindex;
    private WundergroundMeasurement feelslike;
    private WundergroundMeasurement qpf;
    private WundergroundMeasurement snow;
    private String pop;
    private WundergroundMeasurement mslp;

    public String getFCTIME() {
        return FCTIME;
    }

    public void setFCTIME(String FCTIME) {
        this.FCTIME = FCTIME;
    }

    public WundergroundMeasurement getTemp() {
        return temp;
    }

    public void setTemp(WundergroundMeasurement temp) {
        this.temp = temp;
    }

    public WundergroundMeasurement getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(WundergroundMeasurement dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getFctcode() {
        return fctcode;
    }

    public void setFctcode(String fctcode) {
        this.fctcode = fctcode;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public WundergroundMeasurement getWspd() {
        return wspd;
    }

    public void setWspd(WundergroundMeasurement wspd) {
        this.wspd = wspd;
    }

    public String getWdir() {
        return wdir;
    }

    public void setWdir(String wdir) {
        this.wdir = wdir;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getUxi() {
        return uxi;
    }

    public void setUxi(String uxi) {
        this.uxi = uxi;
    }

    public WundergroundMeasurement getWindchill() {
        return windchill;
    }

    public void setWindchill(WundergroundMeasurement windchill) {
        this.windchill = windchill;
    }

    public WundergroundMeasurement getHeatindex() {
        return heatindex;
    }

    public void setHeatindex(WundergroundMeasurement heatindex) {
        this.heatindex = heatindex;
    }

    public WundergroundMeasurement getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(WundergroundMeasurement feelslike) {
        this.feelslike = feelslike;
    }

    public WundergroundMeasurement getQpf() {
        return qpf;
    }

    public void setQpf(WundergroundMeasurement qpf) {
        this.qpf = qpf;
    }

    public WundergroundMeasurement getSnow() {
        return snow;
    }

    public void setSnow(WundergroundMeasurement snow) {
        this.snow = snow;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public WundergroundMeasurement getMslp() {
        return mslp;
    }

    public void setMslp(WundergroundMeasurement mslp) {
        this.mslp = mslp;
    }
}
