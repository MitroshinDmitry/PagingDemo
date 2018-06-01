package com.example.mitroshin.pagingdemo.ui.adapters.photoList;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mitroshin.pagingdemo.R;
import com.example.mitroshin.pagingdemo.databinding.ItemLoadingStateBinding;
import com.example.mitroshin.pagingdemo.databinding.ItemPhotoListBinding;
import com.example.mitroshin.pagingdemo.model.entity.Photo;
import com.example.mitroshin.pagingdemo.network.LoadingState;

import java.util.Objects;

public class PhotoListAdapter extends PagedListAdapter<Photo, RecyclerView.ViewHolder> {

    public static final String TAG = PhotoListAdapter.class.getSimpleName();

    private static final int REGULAR_ITEM_LAYOUT = R.layout.item_photo_list;
    private static final int LOADING_STATE_LAYOUT = R.layout.item_loading_state;

    private final PhotoListItemListener listener;
    private final RetryListener retryListener;
    private final LayoutInflater layoutInflater;

    // TODO Описать сеттер
    private LoadingState loadingState;

    public PhotoListAdapter(LayoutInflater layoutInflater,
                            PhotoListItemListener listener,
                            RetryListener retryListener) {
        super(PhotoDiffCallback);
        this.layoutInflater = layoutInflater;
        this.retryListener = retryListener;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            // TODO Придумай, как бы завязать классы биндингов на соответствующие макеты.
            // Как не странно, просто достать из них ID макета - нельзя.
            case REGULAR_ITEM_LAYOUT: {
                final ItemPhotoListBinding binding = ItemPhotoListBinding.inflate(
                        layoutInflater,
                        parent,
                        false);
                return new PhotoViewHolder(binding, listener);
            }
            case LOADING_STATE_LAYOUT: {
                final ItemLoadingStateBinding binding = ItemLoadingStateBinding.inflate(
                        layoutInflater,
                        parent,
                        false);
                return new LoadingStateViewHolder(binding, retryListener);
            }
            default:
                throw new IllegalArgumentException("Unknown layout resource");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case REGULAR_ITEM_LAYOUT:
                ((PhotoViewHolder)holder).bind(getItem(position));
                break;
            case LOADING_STATE_LAYOUT:
                ((LoadingStateViewHolder)holder).bind(loadingState);
                break;
            default:
                throw new IllegalArgumentException("Unknown layout resource");
        }
    }

    @Override
    public int getItemCount() {
        if (hasExtraRow()) {
            return super.getItemCount() + 1;
        } else {
            return super.getItemCount();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (hasExtraRow() && position == getItemCount() - 1) {
            return LOADING_STATE_LAYOUT;
        } else {
            return REGULAR_ITEM_LAYOUT;
        }
    }

    private boolean hasExtraRow() {
        return loadingState != null && loadingState != LoadingState.CONTENT;
    }

    private static DiffUtil.ItemCallback<Photo> PhotoDiffCallback =
            new DiffUtil.ItemCallback<Photo>() {
        @Override
        public boolean areItemsTheSame(Photo oldItem, Photo newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(Photo oldItem, Photo newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };
}
