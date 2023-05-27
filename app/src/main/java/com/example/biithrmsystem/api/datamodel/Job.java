package com.example.biithrmsystem.api.datamodel; 
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class Job{
    @SerializedName("JobApplications")
    public ArrayList<JobApplication> jobApplications;
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
}
