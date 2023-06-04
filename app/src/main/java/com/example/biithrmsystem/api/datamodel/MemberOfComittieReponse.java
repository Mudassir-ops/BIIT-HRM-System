package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class MemberOfComittieReponse {
    @SerializedName("CommitteeImemberId")
    public int committeeImemberId;
    @SerializedName("CommitteeId")
    public int committeeId;
    @SerializedName("Uid")
    public int uid;

}