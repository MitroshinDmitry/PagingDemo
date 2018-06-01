package com.example.mitroshin.pagingdemo.ui.main.details;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.model.repository.PhotoRepository;
import com.example.mitroshin.pagingdemo.network.LoadingState;

public class PhotoDetailsViewModel extends ViewModel implements PhotoRepository.Contract {

    public final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public final MutableLiveData<Boolean> isError = new MutableLiveData<>();
    public final MutableLiveData<Photo> photo = new MutableLiveData<>();
    private final MutableLiveData<String> photoId = new MutableLiveData<>();

    public PhotoDetailsViewModel(String photoId) {
        this.photoId.setValue(photoId);
        reload();
    }

    public void reload() {
        setupViewType(LoadingState.LOADING);
        PhotoRepository.get().getPhoto(photoId.getValue(), this);
    }

    @Override
    public void onPhotoLoaded(@NonNull Photo photo) {
        setupViewType(LoadingState.CONTENT);
        this.photo.setValue(photo);
    }

    @Override
    public void onPhotoNotAvailable() {
        setupViewType(LoadingState.ERROR);
    }

    private void setupViewType(LoadingState type) {
        isLoading.setValue(type.isLoading);
        isError.setValue(type.isError);
    }
}