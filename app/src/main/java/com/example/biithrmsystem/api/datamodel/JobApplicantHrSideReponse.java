package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class JobApplicantHrSideReponse {
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

}
