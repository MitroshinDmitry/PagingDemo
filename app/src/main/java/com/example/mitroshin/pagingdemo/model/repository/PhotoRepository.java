package com.example.mitroshin.pagingdemo.model.repository;

import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.network.UnsplashClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {

    public interface Contract {
        void onPhotoLoaded(@NonNull Photo photo);
        void onPhotoNotAvailable();
    }

    private static volatile PhotoRepository INSTANCE = new PhotoRepository();

    public synchronized static PhotoRepository get() {
        return INSTANCE;
    }

    public void getPhoto(String id, Contract contract) {
        Call<Photo> photoCall = UnsplashClient.get().getApi().photo(id);
        photoCall.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(@NonNull Call<Photo> call,
                                   @NonNull Response<Photo> response) {
                if (response.body() != null) {
                    contract.onPhotoLoaded(response.body());
                } else {
                    contract.onPhotoNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Photo> call,
                                  @NonNull Throwable t) {
                contract.onPhotoNotAvailable();
            }
        });
    }
}