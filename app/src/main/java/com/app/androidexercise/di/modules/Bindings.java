package com.app.androidexercise.di.modules;

import com.app.androidexercise.data.Repository;
import com.app.androidexercise.data.RepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface Bindings {
    @Binds
    Repository provideRepository(RepositoryImpl repository);
}
