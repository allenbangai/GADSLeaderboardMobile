package com.example.gadsleaderboardmobile.Util;

import com.example.gadsleaderboardmobile.Model.LearningLeadersModel;
import com.example.gadsleaderboardmobile.Model.SkillIQLeadersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/hours")
    Call<List<LearningLeadersModel>> getLearningLeaders();

    @GET("api/skilliq")
    Call<List<SkillIQLeadersModel>> getIQLeaders();
}