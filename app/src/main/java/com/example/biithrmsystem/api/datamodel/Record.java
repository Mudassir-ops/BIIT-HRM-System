package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class Record {
    @SerializedName("Fname")
    public String fname;
    @SerializedName("Uid")
    public int uid;
    public String checkin;
    public String checkout;
    public String status;
}
