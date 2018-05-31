package com.example.mitroshin.pagingdemo.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mitroshin.pagingdemo.ui.main.photoList.PhotoListActivity;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchActivity(PhotoListActivity.class);
    }

    private void launchActivity(Class<? extends Activity> newActivity) {
        Intent intent = new Intent(this, newActivity);
        startActivity(intent);
        finish();
    }
}