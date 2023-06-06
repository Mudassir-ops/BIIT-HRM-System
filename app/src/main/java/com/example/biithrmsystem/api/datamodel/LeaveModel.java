package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class LeaveModel {
    public int leaveappid;
    @SerializedName("Uid")
    public int uid;
    public String leavetype;
    public String startdate;
    public String enddate;
    public String reason;
    public String status;
    public String applydate;

}