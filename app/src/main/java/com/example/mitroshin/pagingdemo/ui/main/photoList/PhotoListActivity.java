package com.example.mitroshin.pagingdemo.ui.main.photoList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.mitroshin.pagingdemo.ui.main.details.PhotoDetailsActivity;

public class PhotoListActivity extends AppCompatActivity implements PhotoListFragment.Contract {

    public static final String TAG = PhotoListActivity.class.getSimpleName();

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

    @Override
    public void showPhotoDetails(String photoId) {
        Intent photoDetailsIntent = PhotoDetailsActivity.newIntent(this, photoId);
        launchActivity(photoDetailsIntent);
    }

    private void launchActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}
