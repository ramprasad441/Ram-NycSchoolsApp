package com.ramprasad.nycschools.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ramprasad.nycschools.model.SchoolDetailPojo;
import com.ramprasad.nycschools.network.CallBackWrapper;
import com.ramprasad.nycschools.network.NetworkClient;
import com.ramprasad.nycschools.network.NycError;

import java.util.List;

/**
 * Created by Ramprasad on 5/3/20.
 */
public class SchoolsDetailViewModel extends ViewModel {

    private static final String TAG = "SchoolsDetailViewModel";


    private MutableLiveData<List<SchoolDetailPojo>> listSchoolScoresInformation;

    public MutableLiveData<List<SchoolDetailPojo>> getListSchoolScoresInformation() {
        if (listSchoolScoresInformation == null) {
            listSchoolScoresInformation = new MutableLiveData<>();
            scoreInfo();
        }

        return listSchoolScoresInformation;
    }

    private void scoreInfo() {
/*        NetworkClient.getInstance().getSchoolScoresInfo().enqueue(new Callback<List<SchoolDetailPojo>>() {
            @Override
            public void onResponse(Call<List<SchoolDetailPojo>> call, Response<List<SchoolDetailPojo>> response) {
                listSchoolScoresInformation.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<SchoolDetailPojo>> call, Throwable t) {
                Log.e(TAG, "onFailure: Erorr in fetching the data");
            }
        });*/

        NetworkClient.getInstance().getSchoolScoresInfo().enqueue(new CallBackWrapper<List<SchoolDetailPojo>>() {
            @Override
            protected void onResponse(List<SchoolDetailPojo> response) {
                listSchoolScoresInformation.setValue(response);
            }

            @Override
            protected void onNetworkFailure(NycError nycError) {
                if (nycError != null){
                    Log.e(TAG, "onFailure: Error school Fetching response" + nycError.getErrorMsg());
                }
            }
        });
    }


}
