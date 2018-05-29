package com.example.mitroshin.pagingdemo.model.repository;

import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.network.UnsplashClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoListRepository {

    public interface Contract {
        void onPhotoListLoaded(@NonNull List<Photo> photoList);
        void onPhotoListNotAvailable();
    }

    private static volatile PhotoListRepository INSTANCE = new PhotoListRepository();

    public synchronized static PhotoListRepository get() {
        return INSTANCE;
    }

    public void getPhotoList(Contract contract) {
        Call<List<Photo>> photoListCall = UnsplashClient.get().getApi().photos();
        photoListCall.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call,
                                   @NonNull Response<List<Photo>> response) {
                if (response.body() != null) {
                    contract.onPhotoListLoaded(response.body());
                } else {
                    contract.onPhotoListNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call,
                                  @NonNull Throwable t) {
                contract.onPhotoListNotAvailable();
            }
        });
    }
}