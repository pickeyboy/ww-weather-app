package au.com.challenge.ww.weatherapp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.adapter.PeriodicForecastAdapter;
import au.com.challenge.ww.weatherapp.ui.presenter.PeriodicDisplayPresenter;
import au.com.challenge.ww.weatherapp.ui.view.MvpViewIf;

public class PeriodicDisplayActivity extends PresentableActivity<PeriodicDisplayPresenter> implements MvpViewIf {

    private ActionBar actionBar;

    @NonNull
    @Override
    protected PeriodicDisplayPresenter createPresenter() {
        return new PeriodicDisplayPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Object getIntentData(String key) {
        return getIntent().getExtras().get(key);
    }

    @Override
    public void bindResult(@NonNull Object obj) {
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter((PeriodicForecastAdapter) obj);
    }

    public void setActionBarTitle(@NonNull String title) {
        actionBar.setTitle(title);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFailureMessage(@NonNull String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
