package com.example.mitroshin.pagingdemo.ui.adapters.photoList;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.mitroshin.pagingdemo.databinding.ItemPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.ui.ScalableHolder;

public class PhotoViewHolder extends RecyclerView.ViewHolder implements ScalableHolder {

    private final ItemPhotoListBinding binding;
    private final PhotoListItemListener listener;

    PhotoViewHolder(ItemPhotoListBinding binding, PhotoListItemListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(Photo photo) {
        binding.setPhoto(photo);
        binding.setScalableHolder(this);
        binding.setListener(listener);
        binding.executePendingBindings();
    }

    @Override
    public ImageView getImageView() {
        return binding.image;
    }

    @Override
    public ConstraintLayout getConstraintLayout() {
        return binding.rootConstraintLayout;
    }
}