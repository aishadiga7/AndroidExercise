package com.app.androidexercise.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.app.androidexercise.R;
import com.app.androidexercise.databinding.ActivityMainBinding;
import com.app.androidexercise.di.factory.AppViewModelFactory;
import com.app.androidexercise.domain.home.HomeScreenViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private ActivityMainBinding mMainBinding;
    @Inject
    AppViewModelFactory mAppViewModelFactory;
    private HomeScreenViewModel mHomeScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mHomeScreenViewModel = ViewModelProviders.of(this, mAppViewModelFactory).get(HomeScreenViewModel.class);
        mMainBinding.setViewModel(mHomeScreenViewModel);
        mMainBinding.setLifecycleOwner(this);
    }
}
