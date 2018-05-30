package com.example.mitroshin.pagingdemo.ui.main.details;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.model.repository.PhotoRepository;

public class PhotoDetailsViewModel extends ViewModel implements PhotoRepository.Contract {

    public final MutableLiveData<Photo> photo = new MutableLiveData<>();

    public PhotoDetailsViewModel(String photoId) {
        PhotoRepository.get().getPhoto(photoId, this);
    }

    @Override
    public void onPhotoLoaded(@NonNull Photo photo) {
        this.photo.setValue(photo);
    }

    @Override
    public void onPhotoNotAvailable() {
        // TODO Обработка ошибки загрузки фотографии
    }
}