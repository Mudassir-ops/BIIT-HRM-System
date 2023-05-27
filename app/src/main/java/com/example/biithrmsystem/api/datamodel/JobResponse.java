package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JobResponse {


    @SerializedName("Jid")
    public int jid;
    @SerializedName("Title")
    public String title;
    public String qualification;
    @SerializedName("Salary")
    public String salary;
    public String experience;
    @SerializedName("LastDateOfApply")
    public String lastDateOfApply;
    @SerializedName("Location")
    public String location;
    @SerializedName("Description")
    public String description;
    public int noofvacancie;
    public String jobstatus;
    @SerializedName("JobApplications")
    public ArrayList<JobApplication> jobApplications;

}
