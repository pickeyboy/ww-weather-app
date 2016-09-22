package au.com.challenge.ww.weatherapp.model;

import java.util.List;

public class PeriodicForecast extends Description {
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
