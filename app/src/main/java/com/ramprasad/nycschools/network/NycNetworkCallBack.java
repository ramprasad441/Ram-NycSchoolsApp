package com.ramprasad.nycschools.network;

/**
 * Created by Ramprasad on 5/16/20.
 */
public interface NycNetworkCallBack<Response, Error> {
    void onSuccessResponse(Response response);
    void onErrorResponse(Error error);
}
