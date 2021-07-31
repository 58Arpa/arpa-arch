package com.arpa.and.basearch.logic;

import android.content.Intent;
import android.os.Bundle;

import com.arpa.and.basearch.R;
import com.arpa.and.basearch.base.WrapBaseActivity;
import com.arpa.and.basearch.databinding.ActivitySubChildBinding;

import java.util.Random;

import androidx.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-07-31 11:19
 */
@AndroidEntryPoint
public class SubChildActivity extends WrapBaseActivity<VMSubChild, ActivitySubChildBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_sub_child;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        viewBind.setViewModel(viewModel);
        viewBind.btnFinish.setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra("test", String.valueOf(new Random().nextGaussian()));
            setResult(RESULT_OK, data);
            finish();
        });
    }
}
