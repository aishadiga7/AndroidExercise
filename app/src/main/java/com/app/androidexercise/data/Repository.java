package com.app.androidexercise.data;

import androidx.lifecycle.LiveData;

import com.app.androidexercise.domain.model.Feed;
import com.app.androidexercise.domain.model.Result;

import java.util.List;

/**
 *  This interface is an abstraction for the data layer.The implementing class should handle all the data access/persistence
 *  login and expose the business models to the outside layers
 */
public interface Repository {

    LiveData<Result<List<Feed>>> getFeeds();
}
