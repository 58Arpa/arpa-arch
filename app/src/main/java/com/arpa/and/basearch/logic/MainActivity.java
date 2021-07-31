package com.arpa.and.basearch.logic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.arpa.and.basearch.R;
import com.arpa.and.basearch.base.WrapBaseActivity;
import com.arpa.and.basearch.databinding.ActivityMainBinding;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-07-31 11:19
 */
@AndroidEntryPoint
public class MainActivity extends WrapBaseActivity<VMMain, ActivityMainBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        viewBind.setViewModel(viewModel);
    }

    @SuppressLint("LogNotTimber")
    @Override
    protected void onStartActivityResult(ActivityResult result) {
        Log.e("@@@@ L33", "MainActivity:onStartActivityResult() -> " + result.getData().getStringExtra("test"));
    }
}
