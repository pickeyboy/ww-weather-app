package au.com.challenge.ww.weatherapp.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.databinding.ActivityWeatherDisplayBinding;
import au.com.challenge.ww.weatherapp.model.Forecast;
import au.com.challenge.ww.weatherapp.ui.presenter.WwWeatherMainPresenter;
import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;

public class WwWeatherMainActivity extends PresentableActivity<WwWeatherMainPresenter> implements MvpViewIf {

    @NonNull
    @Override
    protected WwWeatherMainPresenter createPresenter() {
        return new WwWeatherMainPresenter(this);
    }

    @VisibleForTesting
    ActivityWeatherDisplayBinding binding;

    @VisibleForTesting
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_weather_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressDialog = getPresenter().prepareProgressDialog();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Bundle getIntentData(String key) {
        return null;
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void bindResult(Object result) {
        binding.setForecast((Forecast) result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method is just to support unit test cases
     * @return binding instance
     */
    public ActivityWeatherDisplayBinding getBinding() {
        return  binding;
    }

}
