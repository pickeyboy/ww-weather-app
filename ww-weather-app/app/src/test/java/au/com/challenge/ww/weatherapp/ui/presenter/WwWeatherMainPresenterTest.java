package au.com.challenge.ww.weatherapp.ui.presenter;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.internal.Shadow;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowProgressDialog;

import au.com.challenge.ww.weatherapp.BuildConfig;
import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.model.Forecast;
import au.com.challenge.ww.weatherapp.ui.activity.WwWeatherMainActivity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class WwWeatherMainPresenterTest {

    private WwWeatherMainActivity mainActivity;
    private WwWeatherMainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(WwWeatherMainActivity.class).create().get();
        mainPresenter = new WwWeatherMainPresenter(mainActivity);
    }

    @Test
    public void testPresenterIsNotNull() throws Exception {
        assertNotNull(mainActivity);
        assertNotNull(mainPresenter);
    }

    @Test
    public void testOnStartIfStartsDownloadingData() throws Exception {
        mainPresenter.onStart();
        assertNotNull(ShadowProgressDialog.getLatestDialog());
        assertTrue(ShadowProgressDialog.getLatestAlertDialog().isShowing());
    }

    @Test
    public void testDataFetchSuccessAndDataBindSuccessFully() throws Exception {
        final String TIMEZONE = "AUS/SYDNEY";
        Forecast forecast = new Forecast();
        forecast.setTimezone(TIMEZONE);
        mainPresenter.dataFetchSuccess(forecast);
        assertEquals(TIMEZONE, mainActivity.getBinding().getForecast().getTimezone());
    }

    @Test
    public void testPrepareProgressDialogFunctionality() throws Exception {
        ProgressDialog progressDialog = mainPresenter.prepareProgressDialog();
        Assert.assertNotNull(progressDialog);
        ShadowProgressDialog shadowProgressDialog = Shadows.shadowOf(progressDialog);
        assertEquals(ProgressDialog.STYLE_SPINNER, shadowProgressDialog.getProgressStyle());
        assertFalse(shadowProgressDialog.isCancelable());
    }
}