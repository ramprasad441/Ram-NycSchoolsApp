package com.ramprasad.nycschools.network;

import com.ramprasad.nycschools.model.SchoolDetailPojo;
import com.ramprasad.nycschools.model.Schools;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramprasad on 4/23/20.
 */
public class NetworkClient {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private ApiClient mApiClient;
    private static NetworkClient instance;

    private NetworkClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiClient = retrofit.create(ApiClient.class);
    }

    public static NetworkClient getInstance() {
        if (instance == null) {
            instance = new NetworkClient();
        }
        return instance;
    }

    public Call<List<Schools>> getSchoolsData(){
        return mApiClient.getSchoolsList();
    }

    public Call<List<SchoolDetailPojo>> getSchoolScoresInfo() {
        return mApiClient.getSchoolDetails();
    }

}
