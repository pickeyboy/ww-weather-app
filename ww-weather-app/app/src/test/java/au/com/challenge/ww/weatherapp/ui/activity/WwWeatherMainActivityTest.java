package au.com.challenge.ww.weatherapp.ui.activity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import au.com.challenge.ww.weatherapp.BuildConfig;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)

public class WwWeatherMainActivityTest {
    WwWeatherMainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(WwWeatherMainActivity.class).create().get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        Assert.assertNotNull(mainActivity);
    }
}