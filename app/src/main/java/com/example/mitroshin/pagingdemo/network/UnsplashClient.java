package com.example.mitroshin.pagingdemo.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnsplashClient {
    private static final String BASE_URL = "https://api.unsplash.com";

    private static volatile UnsplashClient INSTANCE = new UnsplashClient();
    private final Retrofit retrofit;
    private final OkHttpClient httpClient;

    private final UnsplashApi api;

    public synchronized static UnsplashClient get() {
        return INSTANCE;
    }

    private UnsplashClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new UnsplashInterceptor());

        httpClient = httpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        api = retrofit.create(UnsplashApi.class);
    }

    public UnsplashApi getApi() {
        return api;
    }
}