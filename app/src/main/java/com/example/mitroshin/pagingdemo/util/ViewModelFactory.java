package com.example.mitroshin.pagingdemo.util;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.mitroshin.pagingdemo.ui.main.details.PhotoDetailsViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    private final String parameter;

    public ViewModelFactory(Application application, String parameter) {
        this.application = application;
        this.parameter = parameter;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PhotoDetailsViewModel.class)) {
            return (T) new PhotoDetailsViewModel(parameter);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}