package com.example.gadsleaderboardmobile.Util;

import com.example.gadsleaderboardmobile.Model.LearningLeadersModel;
import com.example.gadsleaderboardmobile.Model.SkillIQLeadersModel;
import com.example.gadsleaderboardmobile.Model.SubmissionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/hours")
    Call<List<LearningLeadersModel>> getLearningLeaders();

    @GET("api/skilliq")
    Call<List<SkillIQLeadersModel>> getIQLeaders();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<SubmissionModel> createSubmission(@Body SubmissionModel submissionModel);
}