package au.com.challenge.ww.weatherapp.adapter;

import android.databinding.ViewDataBinding;
import android.widget.LinearLayout;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import au.com.challenge.ww.weatherapp.BuildConfig;
import au.com.challenge.ww.weatherapp.model.WeatherItem;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class PeriodicForecastAdapterTest {

    @Test
    public void testPeriodicForecastAdapterCostructor() throws Exception {
        List<WeatherItem> mockedList = mock(ArrayList.class);
        PeriodicForecastAdapter pfa = new PeriodicForecastAdapter(mockedList);
        pfa.getItemCount();
        verify(mockedList, times(1)).size();
    }

    @Ignore("Because Robolectric doesn't support inflating layout with <layout> tags")
    @Test
    public void testOnCreateViewHolderFunctionality() throws Exception {
        List<WeatherItem> mockedList = mock(ArrayList.class);
        PeriodicForecastAdapter pfa = new PeriodicForecastAdapter(mockedList);

        LinearLayout mockedParent = mock(LinearLayout.class);
        when(mockedParent.getContext()).thenReturn(RuntimeEnvironment.application.getApplicationContext());
        assertNotNull(pfa.onCreateViewHolder(mockedParent, 0));
    }

    @Test
    public void testOnBindViewHolderFunctionality() throws Exception {
        List<WeatherItem> dataList = new ArrayList<>();
        dataList.add(mock(WeatherItem.class));
        dataList.add(mock(WeatherItem.class));
        PeriodicForecastAdapter pfa = new PeriodicForecastAdapter(dataList);

        PeriodicForecastAdapter.WwViewHolder mockedHolder = mock(PeriodicForecastAdapter.WwViewHolder.class);
        ViewDataBinding mockedVDB = mock(ViewDataBinding.class);
        when(mockedHolder.getBinding()).thenReturn(mockedVDB);
        pfa.onBindViewHolder(mockedHolder, 1);
        verify(mockedVDB, times(1)).setVariable(any(Integer.class), any());
        verify(mockedVDB, times(1)).executePendingBindings();
    }

    @Test
    public void testGetItemCountForCodeCoverage() throws Exception {
        List<WeatherItem> dataList = new ArrayList<>();
        dataList.add(mock(WeatherItem.class));
        dataList.add(mock(WeatherItem.class));
        PeriodicForecastAdapter pfa = new PeriodicForecastAdapter(dataList);

        assertEquals(2, pfa.getItemCount());

    }
}
