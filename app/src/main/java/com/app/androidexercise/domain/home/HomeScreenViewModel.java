package com.app.androidexercise.domain.home;

import com.app.androidexercise.data.Repository;
import com.app.androidexercise.domain.BaseViewModel;

import javax.inject.Inject;

public class HomeScreenViewModel extends BaseViewModel {

    private Repository mRepository;

    @Inject
    public HomeScreenViewModel(Repository repository) {
        mRepository = repository;
    }
}
