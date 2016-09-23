package au.com.challenge.ww.weatherapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import au.com.challenge.ww.weatherapp.R;
import au.com.challenge.ww.weatherapp.BR;
import au.com.challenge.ww.weatherapp.model.WeatherItem;

public class PeriodicForecastAdapter<T extends WeatherItem> extends RecyclerView.Adapter<PeriodicForecastAdapter.WwViewHolder> {

    List<T> dataList;

    public class WwViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public WwViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public PeriodicForecastAdapter(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public WwViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_list_row, parent, false);
        WwViewHolder holder = new WwViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(WwViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.weather, dataList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
