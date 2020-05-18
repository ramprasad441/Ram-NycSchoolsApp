package com.ramprasad.nycschools.network;

import com.ramprasad.nycschools.model.SchoolDetailPojo;
import com.ramprasad.nycschools.model.Schools;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ramprasad on 4/23/20.
 */
public interface ApiClient {

    @GET("https://data.cityofnewyork.us/resource/s3k6-pzi2.json")
    Call<List<Schools>> getSchoolsList();

    @GET("https://data.cityofnewyork.us/resource/f9bf-2cp4.json")
    Call<List<SchoolDetailPojo>> getSchoolDetails();


}
