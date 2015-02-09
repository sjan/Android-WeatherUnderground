package org.lastresponders.weatherundergroundapp.data.model;

/**
 * Created by sjan on 2/8/2015.
 */
public class WindCondition {
    String mph;
    String kph;
    String dir;

    public String getMph() {
        return mph;
    }

    public void setMph(String mph) {
        this.mph = mph;
    }

    public String getKph() {
        return kph;
    }

    public void setKph(String kph) {
        this.kph = kph;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    String degrees;
}
