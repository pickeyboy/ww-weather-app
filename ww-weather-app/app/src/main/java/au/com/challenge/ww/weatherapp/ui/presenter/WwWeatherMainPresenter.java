package au.com.challenge.ww.weatherapp.ui.presenter;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.model.Forecast;
import au.com.challenge.ww.weatherapp.retrofit.Factory;
import au.com.challenge.ww.weatherapp.retrofit.Feedback;
import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;
import retrofit.Call;

public class WwWeatherMainPresenter extends Presenter<MvpViewIf> {
    private static final String TAG = WwWeatherMainPresenter.class.getSimpleName();

    //For the test project let's keep Lat/Lon simply defined here
    //In actual it can be fetched from device location
    private static final String lat = "33.8688";
    private static final String lon = "151.2093";

    public WwWeatherMainPresenter(@NonNull MvpViewIf view) {
        super(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        String key = getView().getContext().getString(R.string.forecast_api_key);
        Call<Forecast> call = Factory.weatherDataService().getForecastData(key, lat, lon);
        getView().showLoading();
        Factory.enqueue(call, new Feedback<Forecast>() {
            @Override
            public void received(boolean success) {
                Log.d(TAG, "Download forecast data request received");
                getView().hideLoading();
            }

            @Override
            public void success(Forecast model) {
                Log.d(TAG, "Data download success");
                dataFetchSuccess(model);
            }

            @Override
            public void error(Throwable throwable) {
                Log.e(TAG, "Unable to get forecast data", throwable);
                getView().showFailureMessage(throwable.getMessage());
            }
        });
    }

    @VisibleForTesting
    void dataFetchSuccess(Forecast model) {
        getView().bindResult(model);
    }

    public ProgressDialog prepareProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getContext().getString(R.string.loading));
        return progressDialog;
    }
}
