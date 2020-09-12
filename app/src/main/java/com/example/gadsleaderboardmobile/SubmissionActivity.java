package com.example.gadsleaderboardmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gadsleaderboardmobile.Util.Helper;

import java.util.regex.Pattern;

public class SubmissionActivity extends AppCompatActivity {

    private EditText firstName, lastName, emailAddress, githubLink;
    private TextView submit;
    private Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        helper = new Helper(this);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.github_project_link);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitProject();
            }
        });
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

        }
    }
}