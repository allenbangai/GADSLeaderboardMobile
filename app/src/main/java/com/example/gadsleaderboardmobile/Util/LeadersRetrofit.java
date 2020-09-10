package com.example.gadsleaderboardmobile.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadersRetrofit {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gadsapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
}
