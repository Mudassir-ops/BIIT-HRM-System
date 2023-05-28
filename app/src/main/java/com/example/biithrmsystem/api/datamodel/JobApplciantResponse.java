package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class JobApplciantResponse {

    @SerializedName("JobApplicationID")
    public int jobApplicationID;
    @SerializedName("Jid")
    public int jid;
    @SerializedName("Uid")
    public int uid;
    public String name;
    public Object status;
    public Object shortlist;
    @SerializedName("DocumentPath")
    public String documentPath;
    @SerializedName("JobTitle")
    public String jobTitle;
    @SerializedName("JobQualification")
    public String jobQualification;
    @SerializedName("JobSalary")
    public String jobSalary;
    @SerializedName("JobExperience")
    public String jobExperience;
    @SerializedName("LastDateOfApply")
    public String lastDateOfApply;
    @SerializedName("JobLocation")
    public String jobLocation;
    @SerializedName("JobDescription")
    public String jobDescription;
    @SerializedName("NoOfVacancies")
    public int noOfVacancies;

}
