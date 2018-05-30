package com.example.mitroshin.pagingdemo.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.mitroshin.pagingdemo.R;
import com.squareup.picasso.Picasso;

public class UtilBindingAdapter {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.get()
                .load(url)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_image_primary_light_100dp)
                .into(view);
    }
}
