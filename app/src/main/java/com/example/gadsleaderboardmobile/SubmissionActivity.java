package com.example.gadsleaderboardmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SubmissionActivity extends AppCompatActivity {

    private EditText firstName, lastName, emailAddress, githubLink;
    private TextView submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

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

        if(firstNameStr.isEmpty()){

        }else if(lastNameStr.trim().isEmpty()){

        }else if(emailAddressStr.trim().isEmpty()){

        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailAddressStr).matches()){

        }else if(!Patterns.WEB_URL.matcher(githubLinkStr).matches()){

        }else if(githubLinkStr.trim().isEmpty()){

        }else{

        }
    }
}