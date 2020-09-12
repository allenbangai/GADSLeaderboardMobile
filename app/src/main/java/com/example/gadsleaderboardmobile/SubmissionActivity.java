package com.example.gadsleaderboardmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gadsleaderboardmobile.Model.SubmissionModel;
import com.example.gadsleaderboardmobile.Util.Helper;

import java.util.regex.Pattern;

public class SubmissionActivity extends AppCompatActivity {

    private LinearLayout submissionlayout, submissionInfoLayout, cancelSubmissionLayout;
    private RelativeLayout layout;
    private EditText firstName, lastName, emailAddress, githubLink;
    private TextView submit, confirmSubmit;
    private Helper helper;
    private SubmissionModel submissionModel;
    private ImageView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        helper = new Helper(this);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.github_project_link);

        submissionlayout = findViewById(R.id.submission_layout);
        layout = findViewById(R.id.submission_info_xml);

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


    }

    private void confirmSubmission() {
        submissionlayout.setVisibility(View.VISIBLE);
        layout.setVisibility(View.GONE);
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
            submissionlayout.setVisibility(View.GONE);
        }
    }

    public void cancelSubmission(){

    }
}