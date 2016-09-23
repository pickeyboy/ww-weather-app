package au.com.challenge.ww.weatherapp.model;

import android.annotation.SuppressLint;

import java.io.Serializable;

public class Forecast implements Serializable {
    private double latitude;
    private double longitude;
    private String timezone;
    private int offset;
    private String cityName;
    private WeatherItem currently;
    private PeriodicForecast hourly;
    private PeriodicForecast daily;
    private Flags flags;

    @SuppressLint("DefaultLocale")
    public String getTemperatureRange() {
        String range = "";
        if(daily != null && daily.getData() != null && !daily.getData().isEmpty() && daily.getData().get(0) != null) {
            WeatherItem weatherToday = daily.getData().get(0);
            if (weatherToday.getTemperatureMin() == 0f && weatherToday.getTemperatureMax() == 0f) {
                range = String.format("%.1f %cF", weatherToday.getTemperature(), (char) 0x00B0);
            } else {
                range = String.format("%.1f %cF ~ %.1f %cF", weatherToday.getTemperatureMin(), (char) 0x00B0, weatherToday.getTemperatureMax(), (char) 0x00B0);
            }
        }
        return range;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public WeatherItem getCurrently() {
        return currently;
    }

    public void setCurrently(WeatherItem currently) {
        this.currently = currently;
    }

    public PeriodicForecast getHourly() {
        return hourly;
    }

    public void setHourly(PeriodicForecast hourly) {
        this.hourly = hourly;
    }

    public PeriodicForecast getDaily() {
        return daily;
    }

    public void setDaily(PeriodicForecast daily) {
        this.daily = daily;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }
}
