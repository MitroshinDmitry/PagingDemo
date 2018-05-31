package com.example.mitroshin.pagingdemo.ui;

public enum LoadingViewType {
    LOADING(true, false),
    CONTENT(false, false),
    ERROR(false, true);

    public final boolean isLoading;
    public final boolean isError;

    LoadingViewType(boolean isLoading, boolean isError) {
        this.isLoading = isLoading;
        this.isError = isError;
    }
}
