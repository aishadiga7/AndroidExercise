package com.app.androidexercise.di.modules;

import com.app.androidexercise.data.network.ApiInterface;
import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Provides
    @Singleton
    public static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/")
                .build();
    }

    @Provides
    @Singleton
    public static ApiInterface provideApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }

}
