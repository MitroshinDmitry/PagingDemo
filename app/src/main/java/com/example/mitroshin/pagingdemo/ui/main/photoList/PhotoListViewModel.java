package com.example.mitroshin.pagingdemo.ui.main.photoList;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.model.repository.PhotoListRepository;

import java.util.List;

public class PhotoListViewModel extends ViewModel implements PhotoListRepository.Contract {

    public final MutableLiveData<List<Photo>> photoList = new MutableLiveData<>();

    public PhotoListViewModel() {
        PhotoListRepository.get().getPhotoList(this);
    }

    @Override
    public void onPhotoListLoaded(@NonNull List<Photo> photoList) {
        this.photoList.setValue(photoList);
    }

    @Override
    public void onPhotoListNotAvailable() {
        // TODO Обработка ошибки загрузки списка фотографий.
    }
}