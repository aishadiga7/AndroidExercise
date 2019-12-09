package com.app.androidexercise.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.androidexercise.R;
import com.app.androidexercise.databinding.ActivityMainBinding;
import com.app.androidexercise.di.factory.AppViewModelFactory;
import com.app.androidexercise.domain.home.HomeScreenViewModel;
import com.app.androidexercise.ui.model.ListItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mMainBinding;
    @Inject
    AppViewModelFactory mAppViewModelFactory;
    private HomeScreenViewModel mHomeScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mHomeScreenViewModel = ViewModelProviders.of(this, mAppViewModelFactory).get(HomeScreenViewModel.class);
        mHomeScreenViewModel.init();
        mMainBinding.setViewModel(mHomeScreenViewModel);
        mMainBinding.setLifecycleOwner(this);
        mMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        FeedsAdapter feedsAdapter = new FeedsAdapter();
        mMainBinding.recyclerView.setAdapter(feedsAdapter);
        mHomeScreenViewModel.setLoading(true);
        mHomeScreenViewModel.getListLiveData().observe(this, getObserver(feedsAdapter));
        mMainBinding.swipeRefresh.setOnRefreshListener(() -> mHomeScreenViewModel.fetchFeeds().observe(this, getObserver(feedsAdapter)));
        mHomeScreenViewModel.getError().observe(this, this::showMessage);
        mHomeScreenViewModel.getScreenTitle().observe(this, this::setUpToolbarText);


    }



    @NotNull
    private Observer<List<ListItem>> getObserver(FeedsAdapter feedsAdapter) {
        return listItems -> {
            feedsAdapter.setListItems(listItems);
            mHomeScreenViewModel.setLoading(false);
        };
    }


}
