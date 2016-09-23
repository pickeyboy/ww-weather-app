package au.com.challenge.ww.weatherapp.ui.activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowProgressDialog;

import au.com.challenge.ww.weatherapp.BuildConfig;
import au.com.challenge.ww.weatherapp.model.Forecast;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class WwWeatherMainActivityTest {
    private WwWeatherMainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(WwWeatherMainActivity.class).create().get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(mainActivity);
        assertNotNull(mainActivity.binding);
        assertNotNull(mainActivity.progressDialog);
        assertNotNull(mainActivity.getSupportActionBar());
    }

    @Test
    public void testGetContextNotNull() throws Exception {
        assertNotNull(mainActivity.getContext());
    }

    @Test
    public void testShowLoadingShowsLoadingProgressDialog() throws Exception {
        mainActivity.showLoading();
        assertNotNull(ShadowProgressDialog.getLatestDialog());
        assertTrue(ShadowProgressDialog.getLatestAlertDialog().isShowing());
    }

    @Test
    public void testHideLoadingDismissesLoadingProgressDialog() throws Exception {
        mainActivity.showLoading();
        assertNotNull(ShadowProgressDialog.getLatestDialog());
        assertTrue(ShadowProgressDialog.getLatestAlertDialog().isShowing());
        mainActivity.hideLoading();
        assertFalse(ShadowProgressDialog.getLatestAlertDialog().isShowing());
    }

    @Test
    public void testBindingResultCheckIfResultBindsProperly() throws Exception {
        Forecast mockedObject = mock(Forecast.class);
        mainActivity.bindResult(mockedObject);
        assertEquals(mockedObject, mainActivity.binding.getForecast());
    }
}