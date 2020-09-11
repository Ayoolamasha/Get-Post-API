package com.ayoolamasha.apigetpost.NetworkCall;

import com.ayoolamasha.apigetpost.Model.DataResponse;
import com.ayoolamasha.apigetpost.Model.LeadersModel;
import com.ayoolamasha.apigetpost.Model.SkillsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClientInterface {
    @GET("api/hours")
    Call<List<LeadersModel>> getHours();

    @GET("api/skilliq")
    Call<List<SkillsModel>> getScores();
}
