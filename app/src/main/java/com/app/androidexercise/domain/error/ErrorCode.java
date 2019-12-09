package com.app.androidexercise.domain.error;

import androidx.annotation.IntDef;

import static com.app.androidexercise.domain.error.ErrorCode.NULL_RESPOSNSE_FROM_SERVER;

@IntDef({
        NULL_RESPOSNSE_FROM_SERVER
})
public @interface ErrorCode {
    int NULL_RESPOSNSE_FROM_SERVER = 100;
}
