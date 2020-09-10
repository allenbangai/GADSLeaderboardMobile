package com.example.gadsleaderboardmobile.Model;

public class LearningLeadersModel {

    private String name, country, badgeUrl;
    private int hours;

    public LearningLeadersModel() {
    }

    public LearningLeadersModel(String name, String country, String badgeUrl, int hours) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public int getHours() {
        return hours;
    }
}
