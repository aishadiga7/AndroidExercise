package com.app.androidexercise.di.modules;

import androidx.lifecycle.ViewModel;

import com.app.androidexercise.domain.home.HomeScreenViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel.class)
    ViewModel homeScreenViewModel(HomeScreenViewModel homeScreenViewModel);

}
