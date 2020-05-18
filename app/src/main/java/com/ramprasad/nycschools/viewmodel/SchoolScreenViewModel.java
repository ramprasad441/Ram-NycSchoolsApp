package com.ramprasad.nycschools.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ramprasad.nycschools.model.Schools;
import com.ramprasad.nycschools.network.CallBackWrapper;
import com.ramprasad.nycschools.network.NetworkClient;
import com.ramprasad.nycschools.network.NycError;

import java.util.List;

/**
 * Created by Ramprasad on 4/23/20.
 */
public class SchoolScreenViewModel extends ViewModel {

    private static final String TAG = "SchoolScreenViewModel";


    private MutableLiveData<List<Schools>> listMutableLiveData;

    public SchoolScreenViewModel() {
        //listMutableLiveData = new MutableLiveData<>();

    }


    public MutableLiveData<List<Schools>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            getSchoolsInfo();
        }
        return listMutableLiveData;
    }

    private void getSchoolsInfo() {
/*        NetworkClient.getInstance().getSchoolsData().enqueue(new Callback<List<Schools>>() {
            @Override
            public void onResponse(Call<List<Schools>> call, Response<List<Schools>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Schools>> call, Throwable t) {
                //errorResponse.setValue("error");
                Log.e(TAG, "onFailure: Error school Fetching response");
            }
        });*/
        NetworkClient.getInstance().getSchoolsData().enqueue(new CallBackWrapper<List<Schools>>() {
            @Override
            protected void onResponse(List<Schools> response) {
                listMutableLiveData.setValue(response);
            }

            @Override
            protected void onNetworkFailure(NycError nycError) {
                if (nycError != null) {
                    Log.e(TAG, "onFailure: Error school Fetching response" + nycError.getErrorMsg());
                }

            }
        });
    }


}
