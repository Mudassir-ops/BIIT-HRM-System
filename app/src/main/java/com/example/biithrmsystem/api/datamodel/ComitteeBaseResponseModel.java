package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class ComitteeBaseResponseModel {
    @SerializedName("CommitteeId")
    public int committeeId;
    @SerializedName("CommitteeTitle")
    public String committeeTitle;
    @SerializedName("CommitteeHead")
    public int committeeHead;
}