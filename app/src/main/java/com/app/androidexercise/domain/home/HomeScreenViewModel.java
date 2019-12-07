package com.app.androidexercise.domain.home;

import androidx.lifecycle.LiveData;

import com.app.androidexercise.data.Repository;
import com.app.androidexercise.domain.BaseViewModel;
import com.app.androidexercise.domain.model.Feed;
import com.app.androidexercise.ui.model.ListItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static androidx.lifecycle.Transformations.map;

public class HomeScreenViewModel extends BaseViewModel {

    private Repository mRepository;
    private LiveData<List<ListItem>> mListLiveData;


    @Inject
    public HomeScreenViewModel(Repository repository) {
        mRepository = repository;
    }


    public LiveData<List<ListItem>> getFeedsListItems() {
        if (mListLiveData == null) {
            loadFeeds();
        }
        return mListLiveData;
    }

    private void loadFeeds() {
        mListLiveData = map(mRepository.getFeeds(), input -> {
            List<ListItem> listItems = new ArrayList<>();
            if (!input.isError()) {
                if (input.getData() != null) {
                    for (Feed feed : input.getData()) {
                        listItems.add(new ListItem(feed.getTitle(), feed.getDescription(), feed.getImageUrl()));
                    }
                }
            }
            return listItems;
        });
    }
}
