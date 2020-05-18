package com.ramprasad.nycschools.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramprasad.nycschools.R;
import com.ramprasad.nycschools.model.Schools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramprasad on 4/23/20.
 */
public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolsListAdapter.SchoolsViewHolder> {

    private static final String TAG = "SchoolsListAdapter";
    private Context mContext;

    private List<Schools> schoolsList = new ArrayList<>();
    private SchoolsViewHolder.OnSchoolDetailClickListener onSchoolDetailClickListener;


    SchoolsListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    void setOnSchoolDetailClickListener(SchoolsViewHolder.OnSchoolDetailClickListener onSchoolDetailClickListener) {
        this.onSchoolDetailClickListener = onSchoolDetailClickListener;
    }

    /*assigning the list item of the recyclerview*/
    @NonNull
    @Override
    public SchoolsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.schools_list_item, parent, false));
    }


    /*assigning the data from the model class*/
    @Override
    public void onBindViewHolder(@NonNull SchoolsViewHolder holder, int position) {
        holder.bind(schoolsList.get(position), onSchoolDetailClickListener);


/*        String schoolText = schoolsList.get(position).getSchoolNameString();
        String schoolDbn = schoolsList.get(position).getDbn();

        holder.schoolName.setText(schoolText);*/



/*        holder.schoolName.setOnClickListener(v -> {
            Intent navigateToDetailsIntent = new Intent(mContext, SchoolDetailActivity.class);
            //navigateToDetailsIntent.putExtra("school_name", schoolText);
            //navigateToDetailsIntent.putExtra("dbn", schoolDbn);
            mContext.startActivity(navigateToDetailsIntent);
        });*/

        String schoolPhoneNumber = schoolsList.get(position).getPhoneNumber();

        String schoolLocationInMap = schoolsList.get(position).getLocation();
        int startsIndexOf = schoolLocationInMap.indexOf("(");
        int endIndexOf = schoolLocationInMap.indexOf(")");
        String replaceString = schoolLocationInMap.substring(startsIndexOf, endIndexOf + 1);
        String requiredLocationString = schoolLocationInMap.replace(replaceString, "");

        holder.schoolAddress.setText(requiredLocationString);
        holder.schoolPhone.setText(schoolsList.get(position).getPhoneNumber());
        /*<-----------phone number click----------->*/
        holder.schoolPhone.setOnClickListener(v -> {
            Uri callingIntent = Uri.parse(("tel:+1" + schoolPhoneNumber));
            Intent intent = new Intent(Intent.ACTION_DIAL, callingIntent);
            mContext.startActivity(intent);
            //intent.setData(Uri.parse("tel:+1" + phone));
            Log.d(TAG, "onClick: is phone number clicked");
        });
        /*<-----------Address Click----------->*/
        holder.schoolAddress.setOnClickListener(v -> {
            //Uri callingLocation = Uri.parse("Geo Location: =" + schoolLocationInMap);
            Log.d(TAG, "onClick: clicked on location" + requiredLocationString);
            Uri mapIntentUri = Uri.parse("geo:0,0?q=" + requiredLocationString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            mContext.startActivity(mapIntent);
        });
        String emailString = schoolsList.get(position).getSchoolEmail();
        holder.schoolEmail.setText(mContext.getString(R.string.email));
        holder.schoolEmail.setOnClickListener(v -> {
            Log.d(TAG, "onClick: clicked on email" + ' ' + emailString);
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + emailString)); // only email apps should handle this
            emailIntent.putExtra(Intent.EXTRA_EMAIL, emailString);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is an Email to the school");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi");
            mContext.startActivity(emailIntent);


        });
    }

    /*size of the list*/
    @Override
    public int getItemCount() {
        return schoolsList.size();
    }

    void setSchoolsList(List<Schools> schoolsList) {
        this.schoolsList = schoolsList;
        notifyDataSetChanged();
    }

    /*ViewHolder inner class */
    static class SchoolsViewHolder extends RecyclerView.ViewHolder {
        TextView schoolAddress, schoolPhone, schoolEmail;

        SchoolsViewHolder(@NonNull View itemView) {
            super(itemView);
            //schoolName = itemView.findViewById(R.id.school_name);
            schoolAddress = itemView.findViewById(R.id.school_address);
            schoolPhone = itemView.findViewById(R.id.school_phone);
            schoolEmail = itemView.findViewById(R.id.school_email);
        }

        void bind(Schools schools, final OnSchoolDetailClickListener listener) {
            TextView schoolName = itemView.findViewById(R.id.school_name);
            schoolName.setText(schools.getSchoolNameString());
            schoolName.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onSchoolClick(schools.getSchoolNameString());
                }
            });
        }

        /*Interface to implement the click event to navigate to the schools details*/

        public interface OnSchoolDetailClickListener {
            void onSchoolClick(String school_Name);
        }
    }


}
