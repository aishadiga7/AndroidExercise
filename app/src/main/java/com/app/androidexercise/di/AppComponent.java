package com.app.androidexercise.di;


import com.app.androidexercise.App;
import com.app.androidexercise.di.modules.ActivityBuilderModule;
import com.app.androidexercise.di.modules.Bindings;
import com.app.androidexercise.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        Bindings.class,
        NetworkModule.class})
public interface AppComponent {
    void inject(App app);
}
