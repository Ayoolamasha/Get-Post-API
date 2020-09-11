package com.ayoolamasha.apigetpost.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("hours")
    @Expose
    private List<LeadersModel> getLeaders;
    @SerializedName("skilliq")
    @Expose
    private List<SkillsModel> getSkills;

    public List<LeadersModel> getGetLeaders() {
        return getLeaders;
    }

    public void setGetLeaders(List<LeadersModel> getLeaders) {
        this.getLeaders = getLeaders;
    }

    public List<SkillsModel> getGetSkills() {
        return getSkills;
    }

    public void setGetSkills(List<SkillsModel> getSkills) {
        this.getSkills = getSkills;
    }
}
