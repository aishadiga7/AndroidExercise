package com.app.androidexercise.domain.model;

public class Feed {
    private String mTitle;
    private String mDescription;
    private String mImageUrl;

    public Feed(String title, String description, String imageUrl) {
        mTitle = title;
        mDescription = description;
        mImageUrl = imageUrl;
    }

    public Feed(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }


}
