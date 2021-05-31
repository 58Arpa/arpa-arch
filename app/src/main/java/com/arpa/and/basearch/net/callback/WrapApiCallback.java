package com.arpa.and.basearch.net.callback;

import com.arpa.and.base.arch.http.callback.ApiCallback;
import com.arpa.and.basearch.bean.base.Result;
import com.arpa.and.basearch.net.exception.ErrorCode;
import com.arpa.and.basearch.net.exception.ErrorHandler;
import com.arpa.and.basearch.net.exception.ResultError;
import com.arpa.and.basearch.net.exception.ServerProtocolException;
import com.arpa.and.basearch.net.exception.TokenInvalidException;

import retrofit2.Call;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-05-17 10:17
 *
 * <p>
 * 内容描述区域
 * </p>
 */
public abstract class WrapApiCallback <T extends Result> extends ApiCallback<T> {
    @Override
    public void onResponse(Call<T> call, T result) {
        if (result.isSuccess()) {
            onResponse(result);
        } else {
            onError(call, innerFailed(result));
        }
        onFinish();
    }

    private Exception innerFailed(T result) {
        Exception exception;
        if (result.getStatus() == ErrorCode.TOKEN_INVALID) {
            exception = new TokenInvalidException(result.getStatus(), result.getMsg());
        } else {
            exception = new ServerProtocolException(result.getStatus(), result.getMsg());
        }
        return exception;
    }

    @Override
    public void onError(Call<T> call, Throwable t) {
        onFailed(ErrorHandler.handleException(t));
        onFinish();
    }

    public void onFinish() {
    }

    public abstract void onFailed(ResultError error);

    public abstract void onResponse(T data);
}
