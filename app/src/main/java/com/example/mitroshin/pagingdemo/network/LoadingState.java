package com.example.mitroshin.pagingdemo.network;

public enum LoadingState {
    LOADING(true, false),
    CONTENT(false, false),
    ERROR(false, true);

    public final boolean isLoading;
    public final boolean isError;

    LoadingState(boolean isLoading, boolean isError) {
        this.isLoading = isLoading;
        this.isError = isError;
    }
}
