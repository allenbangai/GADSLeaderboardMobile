package com.example.gadsleaderboardmobile.Model;

public class SkillIQLeadersModel {

    private String name;
    private String country;
    private String badgeUrl;
    private int score;

    public SkillIQLeadersModel() {
    }

    public SkillIQLeadersModel(String name, String country, String badgeUrl, int score) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.score = score;
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

    public int getScore() {
        return score;
    }
}
