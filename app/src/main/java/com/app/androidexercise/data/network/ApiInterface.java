package com.app.androidexercise.data.network;

import androidx.lifecycle.LiveData;

import com.app.androidexercise.data.network.model.FeedResponse;
import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    LiveData<Resource<FeedResponse>> getFeeds();

}
