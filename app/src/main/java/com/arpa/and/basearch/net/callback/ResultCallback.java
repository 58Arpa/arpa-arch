package com.arpa.and.basearch.net.callback;


import com.arpa.and.basearch.bean.base.Result;

public abstract class ResultCallback <T> extends WrapApiCallback<Result<T>> {
    @Override
    public void onResponse(Result<T> data) {
        onSuccess(data.getData());
    }

    public abstract void onSuccess(T data);
}