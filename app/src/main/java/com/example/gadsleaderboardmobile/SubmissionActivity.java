package com.example.gadsleaderboardmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gadsleaderboardmobile.Model.SubmissionModel;
import com.example.gadsleaderboardmobile.Util.Helper;
import com.example.gadsleaderboardmobile.Util.JsonPlaceHolderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionActivity extends AppCompatActivity {

    private static final String logat = "com.example.gadsleaderboardmobile.ui.SubmissionActivity";
    private static final String fieldFirstName = "entry.1824927963";
    private static final String fieldLastName = "entry.1877115667";
    private static final String fieldEmailAddress = "entry.2006916086";
    private static final String fieldGithubLink = "entry.284483984";
    private static final String fieldTrack = "entry.642603327";
    private static final String url = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

    private LinearLayout submissionLayout, validateSubmission, submissionInfoLayout, submissionSuccessful, submissionNotSuccessful;
    private RelativeLayout layout;
    private EditText firstName, lastName, emailAddress, githubLink;
    private TextView submit, confirmSubmit;
    private Helper helper;
    private SubmissionModel submissionModel;
    private ImageView cancel;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        helper = new Helper(this);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.github_project_link);

        submissionLayout = findViewById(R.id.submission_layout);
        layout = findViewById(R.id.submission_info_xml);
        submissionSuccessful = findViewById(R.id.submission_successful);
        submissionNotSuccessful = findViewById(R.id.submission_not_successful);
        validateSubmission = findViewById(R.id.validate_submission);

        submissionInfoLayout = findViewById(R.id.cancel_submission_view);
        submissionInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelSubmission();
            }
        });

        cancel = findViewById(R.id.cancel_submission);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelSubmission();
            }
        });

        confirmSubmit = findViewById(R.id.confirm_submit);
        confirmSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmSubmission();
            }
        });

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitProject();
            }
        });

        queue = Volley.newRequestQueue(this);
    }

    JsonPlaceHolderApi jsonPlaceHolderApi;
    private void confirmSubmission() {
        helper.progressDialogStart("Please Wait", "Subimssion is going through");

        StringRequest request = new StringRequest(
                Request.Method.POST,

                url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.length() > 0){
                            helper.toastMessage("successfully posted");

                            submissionSuccessful.setVisibility(View.VISIBLE);
                            validateSubmission.setVisibility(View.GONE);
                        }else{
                            helper.toastMessage("try again");

                            submissionNotSuccessful.setVisibility(View.VISIBLE);
                            validateSubmission.setVisibility(View.GONE);
                        }
                        helper.progressDialogEnd();
                    }
                },

                new Response.ErrorListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        helper.progressDialogEnd();
                        helper.toastMessage( "Error Message \n Submission was not succesfull : " + error.getMessage());
                        Log.d(logat, "Error message: \" + t.getMessage()");

                        submissionNotSuccessful.setVisibility(View.VISIBLE);
                        validateSubmission.setVisibility(View.GONE);
                    }
                }
        );

        /*
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<SubmissionModel> call = jsonPlaceHolderApi.createSubmission(submissionModel.getFistName(), submissionModel.getLastName(),
                submissionModel.getEmailAddress(), submissionModel.getGithubLink());
        call.enqueue(new Callback<SubmissionModel>() {
            @Override
            public void onResponse(Call<SubmissionModel> call, Response<SubmissionModel> response) {
                if(!response.isSuccessful()){
                    helper.toastMessage("Error code : " + response.code() + "\n\n" + "Error Message \n Submission was not succesfull : " + response.message());
                    helper.toastMessage("Error code : " + response.code() + "\n\n" + "Error Message \n Submission was not succesfull : " + response.message());
                    submissionNotSuccessful.setVisibility(View.VISIBLE);
                    validateSubmission.setVisibility(View.GONE);
                    return;
                }

                submissionSuccessful.setVisibility(View.VISIBLE);
                validateSubmission.setVisibility(View.GONE);

            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(Call<SubmissionModel> call, Throwable t) {
                helper.toastMessage( "Error Message \n Submission was not succesfull : " + t.getMessage());
                Log.d(logat, "Error message: \" + t.getMessage()");

                submissionNotSuccessful.setVisibility(View.VISIBLE);
                validateSubmission.setVisibility(View.GONE);
            }
        });


         */
    }

    private void submitProject() {
        String firstNameStr, lastNameStr, emailAddressStr, githubLinkStr;
        firstNameStr = firstName.getText().toString();
        lastNameStr = lastName.getText().toString();
        emailAddressStr = emailAddress.getText().toString();
        githubLinkStr = githubLink.getText().toString();

        if(firstNameStr.trim().isEmpty()){
            helper.toastMessage("first name field is empty");
            firstName.requestFocus();
        }else if(lastNameStr.trim().isEmpty()){
            helper.toastMessage("last name field is empty");
            lastName.requestFocus();
        }else if(emailAddressStr.trim().isEmpty()){
            helper.toastMessage("email address field is empty");
            emailAddress.requestFocus();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailAddressStr).matches()){
            helper.toastMessage("email address is not correct");
            emailAddress.requestFocus();
        }else if(!Patterns.WEB_URL.matcher(githubLinkStr).matches()){
            helper.toastMessage("github web link is not correct");
            githubLink.requestFocus();
        }else if(githubLinkStr.trim().isEmpty()){
            helper.toastMessage("web link field is empty");
            githubLink.requestFocus();
        }else{
            submissionModel = new SubmissionModel(firstNameStr, lastNameStr, emailAddressStr, githubLinkStr);
            layout.setVisibility(View.VISIBLE);
            submissionLayout.setVisibility(View.GONE);
        }
    }

    public void cancelSubmission(){
        submissionLayout.setVisibility(View.VISIBLE);
        validateSubmission.setVisibility(View.VISIBLE);
        layout.setVisibility(View.GONE);
    }
}