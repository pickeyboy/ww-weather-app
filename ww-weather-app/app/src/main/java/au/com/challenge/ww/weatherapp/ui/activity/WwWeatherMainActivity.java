package au.com.challenge.ww.weatherapp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.ui.presenter.WwWeatherMainPresenter;
import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;

public class WwWeatherMainActivity extends PresentableActivity<WwWeatherMainPresenter> implements MvpViewIf {

    @NonNull
    @Override
    protected WwWeatherMainPresenter createPresenter() {
        return new WwWeatherMainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFailureMessage(String msg) {

    }

    @Override
    public void bindResult(Object result) {

    }
}
