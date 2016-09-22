package au.com.challenge.ww.weatherapp.ui.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;


public abstract class Presenter<V extends MvpViewIf> {
    private V mView;

    public Presenter(@NonNull V view) {
        if (view == null) {
            throw new IllegalArgumentException("view != null");
        }
        mView = view;
    }

    @NonNull
    protected V getView() {
        return mView;
    }

    protected Context getContext() {
        return mView.getContext();
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onBackPressed() {
    }

    public void onOptionsItemSelected(MenuItem item) {

    }
}
