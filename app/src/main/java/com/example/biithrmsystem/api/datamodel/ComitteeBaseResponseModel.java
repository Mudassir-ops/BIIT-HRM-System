package com.example.biithrmsystem.api.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ComitteeBaseResponseModel implements Parcelable {
    @SerializedName("CommitteeId")
    public int committeeId;
    @SerializedName("CommitteeTitle")
    public String committeeTitle;
    @SerializedName("CommitteeHead")
    public int committeeHead;

    @SerializedName("CommitteeImemberId")
    public int CommitteeImemberId;

    @SerializedName("Uid")
    public int Uid;

    public ComitteeBaseResponseModel() {
    }

    protected ComitteeBaseResponseModel(Parcel in) {
        committeeId = in.readInt();
        committeeTitle = in.readString();
        committeeHead = in.readInt();
        CommitteeImemberId = in.readInt();
        Uid = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(committeeId);
        dest.writeString(committeeTitle);
        dest.writeInt(committeeHead);
        dest.writeInt(CommitteeImemberId);
        dest.writeInt(Uid);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ComitteeBaseResponseModel> CREATOR = new Creator<ComitteeBaseResponseModel>() {
        @Override
        public ComitteeBaseResponseModel createFromParcel(Parcel in) {
            return new ComitteeBaseResponseModel(in);
        }

        @Override
        public ComitteeBaseResponseModel[] newArray(int size) {
            return new ComitteeBaseResponseModel[size];
        }
    };
}