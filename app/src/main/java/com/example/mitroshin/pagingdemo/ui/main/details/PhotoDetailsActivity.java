package com.example.mitroshin.pagingdemo.ui.main.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class PhotoDetailsActivity extends AppCompatActivity {
    
    public static final String TAG = PhotoDetailsActivity.class.getSimpleName();

    private static final String EXTRA_PHOTO_ID = "photo_id";
    private static final int CONTENT_ID = android.R.id.content;

    public static Intent newIntent(Context context, String photoId) {
        Intent intent = new Intent(context, PhotoDetailsActivity.class);
        intent.putExtra(EXTRA_PHOTO_ID, photoId);
        return intent;
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
    }
}
