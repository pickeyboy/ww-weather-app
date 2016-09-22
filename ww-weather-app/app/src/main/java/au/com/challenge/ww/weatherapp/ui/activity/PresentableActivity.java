package au.com.challenge.ww.weatherapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import au.com.challenge.ww.weatherapp.ui.presenter.Presenter;

abstract class PresentableActivity<T extends Presenter> extends AppCompatActivity {

    private T mPresenter;

    @NonNull
    protected abstract T createPresenter();

    @NonNull
    protected T getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new IllegalStateException("mPresenter == null");
        }

        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        mPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mPresenter.onBackPressed();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mPresenter.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    public void nextActivity(Class<? extends Activity> activityClass, Bundle args) {
        Intent intent = new Intent(getApplication(), activityClass);
        if (args != null) {
            intent.putExtras(args);
        }
        startActivity(intent);
    }
}
