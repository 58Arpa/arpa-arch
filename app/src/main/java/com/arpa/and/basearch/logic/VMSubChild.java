package com.arpa.and.basearch.logic;

import android.app.Application;
import android.os.Bundle;

import com.arpa.and.arch.base.BaseModel;
import com.arpa.and.basearch.base.WrapDataViewModel;

import java.util.Random;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-04-28 11:11
 */
@HiltViewModel
public class VMSubChild extends WrapDataViewModel {

    @Inject
    public VMSubChild(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public void finishResult() {
        Bundle bundle = new Bundle();
        bundle.putString("test", String.valueOf(new Random().nextGaussian()));
        finishResult(bundle);
    }
}
