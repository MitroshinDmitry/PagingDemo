package com.example.mitroshin.pagingdemo.ui.main.photoList;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mitroshin.pagingdemo.databinding.FragmentPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.ui.adapters.PhotoListAdapter;

import java.util.List;

public class PhotoListFragment extends Fragment implements PhotoListAdapter.ItemListener {

    public static final String TAG = PhotoListFragment.class.getSimpleName();

    private FragmentPhotoListBinding binding;
    private PhotoListViewModel viewModel;
    private PhotoListAdapter listAdapter;
    private final RecyclerView.LayoutManager layoutManager =
            new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PhotoListViewModel.class);
        listAdapter = new PhotoListAdapter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPhotoListBinding.inflate(
                getLayoutInflater(),
                container,
                false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel.photoList.observe(this, this::renderPhotoList);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        binding.photoList.setLayoutManager(layoutManager);
        binding.photoList.setAdapter(listAdapter);
    }

    private void renderPhotoList(List<Photo> photoList) {
        listAdapter.setPhotoList(photoList);
    }

    @Override
    public void onPhotoClick(Photo photo) {
        Toast.makeText(getActivity(), "Click on:" + photo.id, Toast.LENGTH_SHORT).show();
    }
}