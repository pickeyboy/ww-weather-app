package au.com.challenge.ww.weatherapp.service;

import au.com.challenge.ww.weatherapp.model.Forecast;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WeatherDataDownloadService {

    @GET("78c4b527be7305597f7ab087d48bed6d/{lat},{lon}")
    Call<Forecast> getForecastData(@Path("lat") String lat,
                                   @Path("lon") String lon);

}
