package com.example.mitroshin.pagingdemo.ui.adapters.photoList;

import android.support.v7.widget.RecyclerView;

import com.example.mitroshin.pagingdemo.databinding.ItemPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private final ItemPhotoListBinding binding;
    private final PhotoListItemListener listener;

    PhotoViewHolder(ItemPhotoListBinding binding, PhotoListItemListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(Photo photo) {
        binding.setPhoto(photo);
        binding.setListener(listener);
        binding.executePendingBindings();
    }
}