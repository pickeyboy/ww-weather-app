package au.com.challenge.ww.weatherapp.ui.view;

import android.content.Context;

public interface MvpViewIf {
    Context getContext();

    void showLoading();

    void hideLoading();

    void showFailureMessage(String msg);

    void bindResult(Object result);
}
