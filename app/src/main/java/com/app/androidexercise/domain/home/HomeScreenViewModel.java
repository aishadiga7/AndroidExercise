package com.app.androidexercise.domain.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
    private MutableLiveData<Throwable> mError = new MutableLiveData<>();
    private MutableLiveData<String> mTitle = new MutableLiveData<>();


    @Inject
    public HomeScreenViewModel(Repository repository) {
        mRepository = repository;
    }


    /**
     * This method will get the list of {@link ListItem} from repository. If the data was previously fetched, it will return
     * the cached data
     * @return
     */
    public LiveData<List<ListItem>> getListLiveData() {
        if (mListLiveData == null)
            fetchFeeds();
        return mListLiveData;
    }

    /**
     * This method will get the list of {@link ListItem} from repository. This method will always fetch the latest data from the network
     * @return
     */
    public LiveData<List<ListItem>> fetchFeeds() {
        mListLiveData = map(mRepository.getFeeds(), input -> {
            mTitle.postValue(mRepository.feedTitle().getValue()); // update the screen title observable on each fetch
            List<ListItem> listItems = new ArrayList<>();
            if (!input.isError()) {
                if (input.getData() != null) {
                    for (Feed feed : input.getData()) {
                        listItems.add(new ListItem(feed.getTitle(), feed.getDescription(), feed.getImageUrl()));
                    }
                }
            }else {
               mError.setValue(input.getError());
            }
            return listItems;
        });
        return mListLiveData;
    }


    /**
     * This method returns the title of the screen
     * @return
     */
    public LiveData<String> getScreenTitle() {
        return mTitle;
    }

    public MutableLiveData<Throwable> getError() {
        return mError;
    }
}
