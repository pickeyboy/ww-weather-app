package au.com.challenge.ww.weatherapp.service;

import au.com.challenge.ww.weatherapp.model.Forecast;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WeatherDataDownloadService {

    @GET("{key}/{lat},{lon}")
    Call<Forecast> getForecastData(@Path("key") String key,
                                   @Path("lat") String lat,
                                   @Path("lon") String lon);

}
