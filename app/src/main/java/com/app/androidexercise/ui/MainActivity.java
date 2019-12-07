package com.app.androidexercise.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.app.androidexercise.R;
import com.app.androidexercise.databinding.ActivityMainBinding;
import com.app.androidexercise.domain.home.HomeScreenViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mMainBinding;
    private HomeScreenViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new HomeScreenViewModel();
        mMainBinding.setViewModel(mViewModel);
        mMainBinding.setLifecycleOwner(this);
    }
}
