package com.app.androidexercise.data.network.model;

import com.google.gson.annotations.SerializedName;

class Row {
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("imageHref")
    public String imageHref;
}
