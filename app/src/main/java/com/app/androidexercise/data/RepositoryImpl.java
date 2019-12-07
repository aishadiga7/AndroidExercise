package com.app.androidexercise.data;

import com.app.androidexercise.data.network.ApiInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RepositoryImpl implements Repository {


    @Inject
    public RepositoryImpl(ApiInterface apiInterface) {
    }
}
