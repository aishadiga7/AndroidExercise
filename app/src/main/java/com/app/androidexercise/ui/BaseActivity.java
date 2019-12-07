package com.app.androidexercise.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseActivity extends AppCompatActivity {

    private MutableLiveData<String> mToolbarText = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpToolbarText();
    }

    protected void setUpToolbarText() {
        mToolbarText.observe(this, title -> {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }
        });
    }

    protected MutableLiveData<String> toolbarText() {
        return mToolbarText;
    }
}
