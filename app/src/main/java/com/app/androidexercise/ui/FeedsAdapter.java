package com.app.androidexercise.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.androidexercise.R;
import com.app.androidexercise.databinding.ItemViewFeedsBinding;
import com.app.androidexercise.ui.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHolder> {

    private List<ListItem> mListItems = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewFeedsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_feeds, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mListItems.get(position));
    }

    public void setListItems(List<ListItem> listItems) {
        mListItems = listItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemViewFeedsBinding mFeedsBinding;

        public ViewHolder(@NonNull ItemViewFeedsBinding itemView) {
            super(itemView.getRoot());
            mFeedsBinding = itemView;
        }

        public void bind(ListItem listItem) {
            mFeedsBinding.setViewModel(listItem);
            mFeedsBinding.executePendingBindings();
        }
    }
}
