package com.app.androidexercise.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.androidexercise.R;
import com.app.androidexercise.databinding.ActivityMainBinding;
import com.app.androidexercise.di.factory.AppViewModelFactory;
import com.app.androidexercise.domain.home.HomeScreenViewModel;

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
        mMainBinding.setViewModel(mHomeScreenViewModel);
        mMainBinding.setLifecycleOwner(this);

        mMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMainBinding.recyclerView.setAdapter(new FeedsAdapter());



    }


}
