package com.app.androidexercise.di;


import com.app.androidexercise.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class})
public interface AppComponent {
    void inject(App app);
}
