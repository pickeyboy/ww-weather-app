package au.com.challenge.ww.weatherapp.ui.presenter;

import android.support.annotation.NonNull;

import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;

public class WwWeatherMainPresenter extends Presenter<MvpViewIf> {

    public WwWeatherMainPresenter(@NonNull MvpViewIf view) {
        super(view);
    }
}
