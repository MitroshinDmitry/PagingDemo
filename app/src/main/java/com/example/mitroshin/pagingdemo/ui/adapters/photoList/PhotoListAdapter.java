package com.example.mitroshin.pagingdemo.ui.adapters.photoList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mitroshin.pagingdemo.databinding.ItemPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    public static final String TAG = PhotoListAdapter.class.getSimpleName();

    private final PhotoListItemListener listener;
    private final LayoutInflater layoutInflater;
    private List<Photo> photoList;

    public PhotoListAdapter(LayoutInflater layoutInflater, PhotoListItemListener listener) {
        this.layoutInflater = layoutInflater;
        this.listener = listener;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
        // TODO Проверять через DiffUtils
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ItemPhotoListBinding binding = ItemPhotoListBinding.inflate(
                layoutInflater,
                parent,
                false);
        return new PhotoViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.bind(photoList.get(position));
    }

    @Override
    public int getItemCount() {
        if (photoList == null) {
            return 0;
        } else {
            return photoList.size();
        }
    }
}
