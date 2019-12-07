package com.app.androidexercise.ui;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.app.androidexercise.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class DataBindingUtilily {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        RequestManager requestManager = Glide.with(view.getContext());
        requestManager
                .load(imageUrl)
                .placeholder(R.drawable.no_image)
                .error(requestManager.load(R.drawable.no_image))
                .into(view);
    }
}
