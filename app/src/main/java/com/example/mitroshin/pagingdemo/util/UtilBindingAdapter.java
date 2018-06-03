package com.example.mitroshin.pagingdemo.util;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintSet;
import android.widget.ImageView;

import com.example.mitroshin.pagingdemo.ui.StaggeredContainer;
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

    @BindingAdapter({"bind:staggeredContainer", "bind:scalableWidth", "bind:scalableHeight"})
    public static void setupImageSizes(ImageView view,
                                       StaggeredContainer staggeredContainer,
                                       int scalableWidth,
                                       int scalableHeight) {
        ConstraintSet constraintSet = new ConstraintSet();
        String ratio = String.format("%d:%d", scalableWidth, scalableHeight);
        constraintSet.clone(staggeredContainer.getConstraintLayout());
        constraintSet.setDimensionRatio(staggeredContainer.getImageView().getId(), ratio);
        constraintSet.applyTo(staggeredContainer.getConstraintLayout());
    }
}
