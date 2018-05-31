package com.example.mitroshin.pagingdemo.ui.main.photoList;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.model.repository.PhotoDataSourceFactory;

public class PhotoListViewModel extends ViewModel {

    private static final int PHOTOS_ON_PAGE = 5;

    public final LiveData<PagedList<Photo>> photoList;
    private final PhotoDataSourceFactory dataSourceFactory;

    public PhotoListViewModel() {
        dataSourceFactory = new PhotoDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(PHOTOS_ON_PAGE)
                .setInitialLoadSizeHint(PHOTOS_ON_PAGE)
                .setEnablePlaceholders(false)
                .build();
        photoList = new LivePagedListBuilder<>(dataSourceFactory, config).build();
    }
}