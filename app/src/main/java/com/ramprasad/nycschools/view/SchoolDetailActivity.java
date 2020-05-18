package com.ramprasad.nycschools.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.ramprasad.nycschools.R;
import com.ramprasad.nycschools.model.SchoolDetailPojo;
import com.ramprasad.nycschools.viewmodel.SchoolsDetailViewModel;

/**
 * Created by Ramprasad on 5/3/20.
 */
public class SchoolDetailActivity extends AppCompatActivity {

    SchoolsDetailViewModel schoolsDetailViewModel;

    TextView tvSchoolName;
    TextView tvTestTaker;
    TextView tvAvgScore;
    TextView tvMathsAvgScore;

    private String schoolStringFromFirstScreen;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_detail);
        setUpToolBar();
        /*getting data from the previous activity*/
        //Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            schoolStringFromFirstScreen = bundle.getString("school_name");
        }

        tvSchoolName = findViewById(R.id.received_school);
        tvTestTaker = findViewById(R.id.test_taker);
        tvAvgScore = findViewById(R.id.avg_score);
        tvMathsAvgScore = findViewById(R.id.maths_avg_score);
        //String nameOfTheSchool = intent.getStringExtra("school_name");
        //String schoolDbn = intent.getStringExtra("dbn");
        tvSchoolName.setText(schoolStringFromFirstScreen);
        //tvSchoolDbn.setText(schoolDbn);

        schoolsDetailViewModel = ViewModelProviders.of(this).get(SchoolsDetailViewModel.class);
        schoolsDetailViewModel.getListSchoolScoresInformation().observe(this, schoolDetailPojos -> {
            if (schoolDetailPojos != null) {
                for (SchoolDetailPojo schoolDetailPojo : schoolDetailPojos) {
                    if (schoolDetailPojo.getSchoolName().equalsIgnoreCase(schoolStringFromFirstScreen)) {
                        tvSchoolName.setText(schoolDetailPojo.getSchoolName());
                        if (schoolDetailPojo.getNumOfSatTestTakers() != null)
                            tvTestTaker.setText(schoolDetailPojo.getNumOfSatTestTakers());
                        tvAvgScore.setText(schoolDetailPojo.getSatWritingAvgScore());
                        tvMathsAvgScore.setText(schoolDetailPojo.getSatMathAvgScore());
                    }
                }
            }
        });

    }

    private void setUpToolBar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.school_detail);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
