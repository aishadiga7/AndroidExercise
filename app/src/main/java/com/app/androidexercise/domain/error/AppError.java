package com.app.androidexercise.domain.error;

import androidx.annotation.Nullable;

/**
 * Class represent the possible app side errors
 */
public class AppError extends Throwable {
    int errorCode;

    public AppError(@ErrorCode int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AppError)) {
            return false;
        }
        AppError object = (AppError) o;
        return errorCode == object.errorCode;
    }
}
