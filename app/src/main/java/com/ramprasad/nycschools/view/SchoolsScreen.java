package com.ramprasad.nycschools.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramprasad.nycschools.R;
import com.ramprasad.nycschools.viewmodel.SchoolScreenViewModel;

/**
 * Created by Ramprasad on 4/23/20.
 */
public class SchoolsScreen extends AppCompatActivity implements SchoolsListAdapter.SchoolsViewHolder.OnSchoolDetailClickListener {

    SchoolScreenViewModel schoolScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schools_screen);
        /*MODE_NIGHT_FOLLOW_SYSTEM – Uses the system settings to determine the time of day
        and toggles NightMode accordingly. This is the default argument.*/
        /*MODE_NIGHT_AUTO – This tries to auto-detect the time from the device
        location APIs. If the runtime permission for location services isn’t granted, then it uses the system time.*/

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); //For night mode theme
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //For day mode theme
        /*or Dark Mode can be also introduced to the  enabled by just adding the
        new values folder in the "res" folder of the code base example: values-night and we need to make sure styles.xml
        in the values-night with  app theme <style name="AppTheme" parent="Theme.AppCompat.DayNight">*/
        schoolScreenViewModel = ViewModelProviders.of(this).get(SchoolScreenViewModel.class);


        //schoolScreenViewModel.getListMutableLiveData();
        RecyclerView recyclerView = findViewById(R.id.schools_recycler_view);
        final SchoolsListAdapter schoolsListAdapter = new SchoolsListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolsListAdapter);
        schoolsListAdapter.setOnSchoolDetailClickListener(SchoolsScreen.this);


        schoolScreenViewModel.getListMutableLiveData().observe(this, schoolList -> {
                    schoolsListAdapter.setSchoolsList(schoolList);
                    String numOfSchools = getResources().getString(R.string.number_of_schools_colon);
                    int listSize = schoolList.size();
                    String stm = String.valueOf(listSize);
                    Toast.makeText(SchoolsScreen.this, numOfSchools + stm, Toast.LENGTH_LONG).show();
            /*Snackbar.make((SchoolsScreen), combine, Snackbar.LENGTH_LONG)
                    .setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                    .show();*/
                }
        );

    }

    @Override
    public void onSchoolClick(String school_Name) {
        Intent intent = new Intent(SchoolsScreen.this, SchoolDetailActivity.class);
        intent.putExtra("school_name", school_Name);
        startActivity(intent);
    }
}
