package com.example.mitroshin.pagingdemo.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.mitroshin.pagingdemo.ui.main.photoList.PhotoListFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private static final int CONTENT_ID = android.R.id.content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isContentEmpty()) {
            showPhotoList();
        }
    }

    private boolean isContentEmpty() {
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(CONTENT_ID);
        return currentFragment == null;
    }

    private void showPhotoList() {
        getSupportFragmentManager().beginTransaction()
                .replace(CONTENT_ID, new PhotoListFragment())
                .commit();
    }
}
