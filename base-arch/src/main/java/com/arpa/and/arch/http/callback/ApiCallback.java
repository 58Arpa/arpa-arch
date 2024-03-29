package com.arpa.and.arch.http.callback;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import timber.log.Timber;

public abstract class ApiCallback <T> implements Callback<T> {
    @Override
    public void onResponse(@NonNull Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T result = response.body();
            // Timber.d("Response:" + result);
            onResponse(call, result);
        } else {
            onError(call, new HttpException(response));
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        Timber.w(t);
        onError(call, t);
    }

    public abstract void onResponse(Call<T> call, T result);

    public abstract void onError(Call<T> call, Throwable t);
}
