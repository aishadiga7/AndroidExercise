package com.app.androidexercise.domain.error;

import androidx.annotation.IntDef;

import static com.app.androidexercise.domain.error.ErrorCode.NO_DATA_FOUND;
import static com.app.androidexercise.domain.error.ErrorCode.NULL_RESPOSNSE_FROM_SERVER;

@IntDef({
        NULL_RESPOSNSE_FROM_SERVER,
        NO_DATA_FOUND
})
public @interface ErrorCode {
    int NULL_RESPOSNSE_FROM_SERVER = 100;
    int NO_DATA_FOUND = 101;
}
