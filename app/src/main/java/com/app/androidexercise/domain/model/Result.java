package com.app.androidexercise.domain.model;

import androidx.annotation.NonNull;

/**
 * Data holder which can hold the success or error state.
 * @param <T>
 */
public class Result<T> {

    T data;
    Throwable mError;

    public Result(@NonNull T data) {
        this.data = data;
    }

    public Result(Throwable error) {
        mError = error;
    }


    public Throwable getError() {
        return mError;
    }

    public T getData() {
        return data;
    }

    public boolean isError() {
        return mError != null;
    }

}
