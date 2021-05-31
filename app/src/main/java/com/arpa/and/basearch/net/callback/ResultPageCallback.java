package com.arpa.and.basearch.net.callback;


import com.arpa.and.basearch.bean.base.ResultPage;

import java.util.List;

public abstract class ResultPageCallback <T> extends WrapApiCallback<ResultPage<T>> {

    @Override
    public void onResponse(ResultPage<T> data) {
        onSuccess(data.getData().getRecords());
    }

    public abstract void onSuccess(List<T> data);
}
