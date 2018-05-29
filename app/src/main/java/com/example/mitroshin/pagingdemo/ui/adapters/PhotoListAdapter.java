package com.example.mitroshin.pagingdemo.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.mitroshin.pagingdemo.databinding.ItemPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private final Fragment fragment;
    private List<Photo> photoList;

    public PhotoListAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
        // TODO Проверять через DiffUtils
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ItemPhotoListBinding binding = ItemPhotoListBinding.inflate(
                fragment.getLayoutInflater(),
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemPhotoListBinding binding;

        ViewHolder(ItemPhotoListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Photo photo) {
            binding.setPhoto(photo);
            binding.setHolder(this);
            binding.executePendingBindings();
        }

        public void onPhotoClick() {
            // TODO ОБработка нажатия на фотографию
        }
    }
}
