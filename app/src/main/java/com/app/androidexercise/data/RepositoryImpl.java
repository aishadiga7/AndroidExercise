package com.app.androidexercise.data;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
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
        return Transformations.map(mApiInterface.getFeeds(), input -> {
            List<Feed> feeds = new ArrayList<>();
            if (input.isSuccess()) {
                if (input.getResource() != null && input.getResource().rows != null) {
                    for (Row row : input.getResource().rows) {
                        if (!TextUtils.isEmpty(row.title) && TextUtils.isEmpty(row.description)) {
                            Feed feed = new Feed(row.title, row.description, row.imageHref);
                            feeds.add(feed);
                        }
                    }
                }
                return new Result<>(feeds);
            } else {
                return new Result<>(input.getError());
            }
        });

    }
}
