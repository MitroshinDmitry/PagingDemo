package com.example.mitroshin.pagingdemo.ui.adapters.photoList;

import android.support.v7.widget.RecyclerView;

import com.example.mitroshin.pagingdemo.databinding.ItemLoadingStateBinding;
import com.example.mitroshin.pagingdemo.ui.LoadingViewType;

public class LoadingStateViewHolder extends RecyclerView.ViewHolder {

    private final ItemLoadingStateBinding binding;
    private final RetryListener listener;

    LoadingStateViewHolder(ItemLoadingStateBinding binding, RetryListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(LoadingViewType loadingViewType) {
        binding.setViewType(loadingViewType);
        binding.setListener(listener);
        binding.executePendingBindings();
    }
}
