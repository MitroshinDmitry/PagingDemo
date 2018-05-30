package com.example.mitroshin.pagingdemo.ui.main.details;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mitroshin.pagingdemo.databinding.FragmentPhotoDetailsBinding;
import com.example.mitroshin.pagingdemo.util.ViewModelFactory;

public class PhotoDetailsFragment extends Fragment {

    public static final String TAG = PhotoDetailsFragment.class.getSimpleName();

    private static final String ARGUMENT_PHOTO_ID = "photo_id";

    private FragmentPhotoDetailsBinding binding;
    private ViewModelFactory viewModelFactory;
    private PhotoDetailsViewModel viewModel;

    public static PhotoDetailsFragment newInstance(String photoId) {
        Bundle args = new Bundle();
        args.putString(ARGUMENT_PHOTO_ID, photoId);
        PhotoDetailsFragment fragment = new PhotoDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelFactory = new ViewModelFactory(
                getActivity().getApplication(),
                getStringArgument(ARGUMENT_PHOTO_ID));
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(PhotoDetailsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPhotoDetailsBinding.inflate(
                getLayoutInflater(),
                container,
                false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    private String getStringArgument(String argumentName) {
        if (getArguments() != null) {
            return getArguments().getString(argumentName);
        } else {
            return null;
        }
    }
}