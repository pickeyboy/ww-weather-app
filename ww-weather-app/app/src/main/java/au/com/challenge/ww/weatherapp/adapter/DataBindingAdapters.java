package au.com.challenge.ww.weatherapp.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class DataBindingAdapters {
    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }
}
