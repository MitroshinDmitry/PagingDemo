package com.example.mitroshin.pagingdemo.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UnsplashInterceptor implements Interceptor {
    private static final String API_KEY =
            "12e126f9e204a860a1aa4bf9f1412dc5e7108e3a0ea4cb9a76d6e71a0df23262";
    private static final String PARAMETER_NAME_API_KEY = "client_id";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalUrl = originalRequest.url();

        HttpUrl newUrl = originalUrl.newBuilder()
                .addQueryParameter(PARAMETER_NAME_API_KEY, API_KEY)
                .build();

        Request newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build();

        return chain.proceed(newRequest);
    }
}