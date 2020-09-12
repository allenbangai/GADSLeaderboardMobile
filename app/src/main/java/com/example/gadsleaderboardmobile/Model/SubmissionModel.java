package com.example.gadsleaderboardmobile.Model;

import retrofit2.http.Field;

public class SubmissionModel {
    String fistName;
    String lastName;
    String emailAddress;
    String githubLink;

    public SubmissionModel(String fistName, String lastName, String emailAddress, String githubLink) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.githubLink = githubLink;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getGithubLink() {
        return githubLink;
    }
}
