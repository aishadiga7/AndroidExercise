package com.app.androidexercise.data.network.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedResponse {
    @SerializedName("title")
    public String title;
    @SerializedName("rows")
    public List<Row> rows;
}
