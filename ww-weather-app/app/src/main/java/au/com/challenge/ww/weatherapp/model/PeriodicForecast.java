package au.com.challenge.ww.weatherapp.model;

import java.io.Serializable;
import java.util.List;

public class PeriodicForecast extends Description implements Serializable{
    List<WeatherItem> data;

    public PeriodicForecast(Description des) {
        setSummary(des.getSummary());
        setIcon(des.getIcon());
    }

    public PeriodicForecast() {

    }

    public List<WeatherItem> getData() {
        return data;
    }

    public void setData (List<WeatherItem> forecastList) {
        this.data = forecastList;
    }
}
