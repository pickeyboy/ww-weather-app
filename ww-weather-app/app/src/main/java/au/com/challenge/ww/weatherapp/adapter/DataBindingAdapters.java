package au.com.challenge.ww.weatherapp.adapter;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

public class DataBindingAdapters {
    @BindingAdapter("android:src")
    public static void setImageResource(@NonNull ImageView imageView, @DrawableRes int resource){
        imageView.setImageResource(resource);
    }
}
