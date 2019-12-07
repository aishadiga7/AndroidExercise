package com.app.androidexercise.data;

import androidx.lifecycle.LiveData;
import com.app.androidexercise.domain.model.Feed;
import com.app.androidexercise.domain.model.Result;
import java.util.List;

public interface Repository {

    LiveData<Result<List<Feed>>> getFeeds();
}
