package com.example.mitroshin.pagingdemo.model.repository;

import android.arch.paging.DataSource;

import com.example.mitroshin.pagingdemo.model.entity.Photo;

public class PhotoDataSourceFactory extends DataSource.Factory<String, Photo> {

    @Override
    public DataSource<String, Photo> create() {
        return new PhotoDataSource();
    }
}