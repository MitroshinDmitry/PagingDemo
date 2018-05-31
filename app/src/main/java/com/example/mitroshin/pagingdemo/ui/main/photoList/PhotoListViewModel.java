package com.example.mitroshin.pagingdemo.ui.main.photoList;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mitroshin.pagingdemo.model.entity.Photo;

import java.util.List;

public class PhotoListViewModel extends ViewModel {

    public final MutableLiveData<List<Photo>> photoList = new MutableLiveData<>();

    public PhotoListViewModel() {
    }
}