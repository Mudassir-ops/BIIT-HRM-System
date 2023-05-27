package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;


public class JobApplication {
    @SerializedName("User")
    public User user;
    @SerializedName("JobApplicationID")
    public int jobApplicationID;
    @SerializedName("Jid")
    public int jid;
    @SerializedName("Uid")
    public int uid;
    public String name;
    public String status;
    public Object shortlist;
    @SerializedName("DocumentPath")
    public String documentPath;
    @SerializedName("Job")
    public Job job;
}
