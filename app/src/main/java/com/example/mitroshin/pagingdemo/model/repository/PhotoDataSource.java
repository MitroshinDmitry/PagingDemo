package com.example.mitroshin.pagingdemo.model.repository;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.network.UnsplashClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataSource extends ItemKeyedDataSource<String, Photo> {

    public interface Contract {
        void onPhotoListLoaded(List<Photo> photoList);
        void onPhotoListNotAvailable();
    }

    private Contract contract;

    PhotoDataSource(Contract contract) {
        this.contract = contract;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params,
                            @NonNull LoadInitialCallback<Photo> callback) {
        UnsplashClient.get().getApi().photos(1).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call,
                                   @NonNull Response<List<Photo>> response) {
                if (response.body() != null) {
                    callback.onResult(response.body());
                    contract.onPhotoListLoaded(response.body());
                } else {
                    callback.onResult(Collections.emptyList());
                    contract.onPhotoListNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call,
                                  @NonNull Throwable t) {
                callback.onResult(Collections.emptyList());
                contract.onPhotoListNotAvailable();
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<String> params,
                          @NonNull LoadCallback<Photo> callback) {
        UnsplashClient.get().getApi().photos(2).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call,
                                   @NonNull Response<List<Photo>> response) {
                if (response.body() != null) {
                    callback.onResult(response.body());
                    contract.onPhotoListLoaded(response.body());
                } else {
                    callback.onResult(Collections.emptyList());
                    contract.onPhotoListNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call,
                                  @NonNull Throwable t) {
                callback.onResult(Collections.emptyList());
                contract.onPhotoListNotAvailable();
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params,
                           @NonNull LoadCallback<Photo> callback) {

    }

    @NonNull
    @Override
    public String getKey(@NonNull Photo item) {
        return item.id;
    }
}