package com.example.mitroshin.pagingdemo.network;

import com.example.mitroshin.pagingdemo.model.entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UnsplashApi {

    @GET("/photos")
    Call<List<Photo>> photos();

    @GET("/photos/{id}")
    Call<Photo> photo(@Path("id") String id);
}