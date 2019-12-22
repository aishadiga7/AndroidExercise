package com.app.androidexercise.domain.util;

public class Validation {

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
