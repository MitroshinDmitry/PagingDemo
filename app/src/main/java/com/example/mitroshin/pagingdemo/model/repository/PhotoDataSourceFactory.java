package com.example.mitroshin.pagingdemo.model.repository;

import android.arch.paging.DataSource;

import com.example.mitroshin.pagingdemo.model.entity.Photo;

public class PhotoDataSourceFactory extends DataSource.Factory<Integer, Photo> {

    @Override
    public DataSource<Integer, Photo> create() {
        return new PhotoDataSource();
    }
}