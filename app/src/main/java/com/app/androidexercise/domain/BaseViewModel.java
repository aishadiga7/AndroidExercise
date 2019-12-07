package com.app.androidexercise.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);


    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setLoading(boolean isLoading) {
        this.isLoading.postValue(isLoading);
    }
}
