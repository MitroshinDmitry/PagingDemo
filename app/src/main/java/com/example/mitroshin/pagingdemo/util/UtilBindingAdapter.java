package com.example.mitroshin.pagingdemo.util;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.mitroshin.pagingdemo.R;
import com.squareup.picasso.Picasso;

public class UtilBindingAdapter {

    @BindingAdapter({"bind:imageUrl", "bind:placeHolder"})
    public static void loadImage(ImageView view, String url, Drawable placeHolder) {
        Picasso.get()
                .load(url)
                .fit()
                .centerInside()
                .placeholder(placeHolder)
                .into(view);
    }
}
