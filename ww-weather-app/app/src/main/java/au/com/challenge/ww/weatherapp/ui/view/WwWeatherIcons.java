package au.com.challenge.ww.weatherapp.ui.view;

import au.com.challenge.ww.weatherapp.R;

public enum WwWeatherIcons {
    CLEAR_DAY("clear-day", R.drawable.sunny),
    CLEAR_NIGHT("clear-night", R.drawable.clear_night),
    PARTLY_CLOUDY_DAY("partly-cloudy-day", R.drawable.partly_sunny),
    PARTLY_CLOUDY_NIGHT("partly-cloudy-night", R.drawable.cloudy_night),
    RAIN("rain", R.drawable.rain),
    SNOW("snow", R.drawable.snow),
    WIND("wind", R.drawable.windy),
    CLOUDY("cloudy", R.drawable.cloudy),
    UNKNOWN("unkonwn", R.drawable.unknown);

    public int resource;
    public String key;

    WwWeatherIcons(String key, int resource) {
        this.key = key;
        this.resource = resource;
    }

    public static WwWeatherIcons findIcon(String icon) {
        for (WwWeatherIcons w : WwWeatherIcons.values()) {
            if (w.key.equalsIgnoreCase(icon)) {
                return w;
            }
        }
        return WwWeatherIcons.UNKNOWN;
    }
}
