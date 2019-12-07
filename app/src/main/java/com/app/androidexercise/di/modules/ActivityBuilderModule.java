package com.app.androidexercise.di.modules;

import com.app.androidexercise.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity provideMainActivity();
}
