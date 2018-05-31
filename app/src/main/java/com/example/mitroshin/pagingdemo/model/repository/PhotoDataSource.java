package com.example.mitroshin.pagingdemo.model.repository;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.network.UnsplashClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataSource extends PageKeyedDataSource<Integer, Photo> {

    private static final int FIRST_PAGE_NUMBER = 1;
    private static final int SECOND_PAGE_NUMBER = 2;
    private static final int INCREMENT_PAGE_VALUE = 1;

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params,
                           @NonNull LoadCallback<Integer, Photo> callback) {

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params,
                            @NonNull LoadInitialCallback<Integer, Photo> callback) {

        UnsplashClient.get().getApi().photos(FIRST_PAGE_NUMBER, params.requestedLoadSize)
                .enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call,
                                   @NonNull Response<List<Photo>> response) {
                if (response.body() != null) {
                    callback.onResult(response.body(), null, SECOND_PAGE_NUMBER);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call,
                                  @NonNull Throwable t) {
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params,
                          @NonNull LoadCallback<Integer, Photo> callback) {
        UnsplashClient.get().getApi().photos(params.key, params.requestedLoadSize)
                .enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call,
                                   @NonNull Response<List<Photo>> response) {
                if (response.body() != null) {
                    callback.onResult(
                            response.body(),
                            params.key + INCREMENT_PAGE_VALUE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call,
                                  @NonNull Throwable t) {
            }
        });
    }
}