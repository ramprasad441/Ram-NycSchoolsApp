package com.ramprasad.nycschools.network;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramprasad on 5/16/20.
 */
public abstract class CallBackWrapper<APIResponseClass> implements Callback<APIResponseClass> {

    protected abstract void onResponse(APIResponseClass response);

    protected abstract void onNetworkFailure(NycError error);



    @Override
    public void onResponse(@NonNull Call<APIResponseClass> call, Response<APIResponseClass> response) {
        assert response.body() != null;
        assert response.errorBody() != null;

        if (response.code()== 200) {
            Log.v("response", response.body().toString());
            onResponse(response.body());
        } else if (response.code() == 411) {
            NycError nycError = new NycError.NycErrorBuilder(response.message())
                    .setErrorDescription(getErrorCodeDesc(response.code()))
                    .setErrorCode(String.valueOf(response.code()))
                    .setRequestMethod(call.request().method())
                    .build();
            try {
                nycError.setErrorResponse(response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("APIError-URL",String.valueOf(call.request().url()));
            Log.e("APIError-Desc", "\n" + response.code() + "\n");
            onNetworkFailure(nycError);
        }

    }



    @Override
    public void onFailure(Call<APIResponseClass> call, Throwable t) {
        boolean isCancelled = t.getCause() != null && t.getCause().getMessage() != null && t.getCause().getMessage().equalsIgnoreCase("Canceled");

        if (!call.isCanceled() || !isCancelled) {
            NycError nycError;
            t.fillInStackTrace();
            nycError = new NycError.NycErrorBuilder(t.getMessage())
                    .setErrorDescription(t.fillInStackTrace().getMessage())
                    .build();
            onNetworkFailure(nycError);
        }
    }

    private String getErrorCodeDesc(Integer errorCode){
        String errorMsg="No specific description found.";

        switch (errorCode){
            case 201:
                return "Created: the request was successful, and one or more entities was created.";
            case 400:
                return "Bad Request: the request was not properly formed and therefore was not successful.";
            case 401:
                return " Unauthorized";
            case 404:
                return " Resource Not found";
            case 503:
                return " Service Unavailable: timeout error";
        }

        return errorMsg;
    }
}
