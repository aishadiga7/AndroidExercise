package com.app.androidexercise.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.app.androidexercise.data.network.ApiInterface;
import com.app.androidexercise.data.network.model.Row;
import com.app.androidexercise.domain.model.Feed;
import com.app.androidexercise.domain.model.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RepositoryImpl implements Repository {

    private ApiInterface mApiInterface;

    @Inject
    public RepositoryImpl(ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }

    @Override
    public LiveData<Result<List<Feed>>> getFeeds() {
        return Transformations.switchMap(mApiInterface.getFeeds(), input -> {
            List<Feed> feeds = new ArrayList<>();
            if (input.isSuccess()) {
                if (input.getResource() != null) {
                    if (input.getResource().rows != null) {
                        for (Row row : input.getResource().rows) {
                            Feed feed = new Feed(row.title, row.description, row.imageHref);
                            feeds.add(feed);
                        }
                    }
                }
                return new MutableLiveData<>(new Result<>(feeds));
            } else {
                return new MutableLiveData<>(new Result<>(input.getError()));
            }
        });

    }
}
