package au.com.challenge.ww.weatherapp.ui.presenter;

import android.support.annotation.NonNull;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.adapter.PeriodicForecastAdapter;
import au.com.challenge.ww.weatherapp.model.Forecast;
import au.com.challenge.ww.weatherapp.model.WeatherItem;
import au.com.challenge.ww.weatherapp.ui.activity.PeriodicDisplayActivity;
import au.com.challenge.ww.weatherapp.ui.view.Constants;
import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;

public class PeriodicDisplayPresenter extends Presenter<MvpViewIf> {

    private static String TAG = PeriodicDisplayPresenter.class.getName();

    public PeriodicDisplayPresenter(@NonNull MvpViewIf view) {
        super(view);
    }

    public void onStart() {
        Forecast forecast = (Forecast) getView().getIntentData(Forecast.class.getName());

        if (forecast == null) {
            getView().showFailureMessage(getContext().getString(R.string.err_data_unavilable));
        } else {
            PeriodicForecastAdapter<? extends WeatherItem> periodicForecastAdapter;
            String actionBarTitle;

            if (Constants.HOURLY.equals(((PeriodicDisplayActivity) getContext()).getIntent().getExtras().getString(Constants.PERIOD))) {
                periodicForecastAdapter = new PeriodicForecastAdapter<>(forecast.getHourly().getData());
                actionBarTitle = getContext().getString(R.string.hourly_title);
            } else {
                periodicForecastAdapter = new PeriodicForecastAdapter<>(forecast.getDaily().getData());
                actionBarTitle = getContext().getString(R.string.daily_title);
            }
            getView().bindResult(periodicForecastAdapter);
            ((PeriodicDisplayActivity) getView()).setActionBarTitle(actionBarTitle);
        }
    }
}
