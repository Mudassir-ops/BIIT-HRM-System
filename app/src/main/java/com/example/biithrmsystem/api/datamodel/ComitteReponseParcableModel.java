package com.example.biithrmsystem.api.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class ComitteReponseParcableModel implements Parcelable {

    public int committeeId;
    public String committeeTitle;
    public int committeeHead;


    public ComitteReponseParcableModel() {
    }

    public ComitteReponseParcableModel(int committeeId, String committeeTitle, int committeeHead) {
        this.committeeId = committeeId;
        this.committeeTitle = committeeTitle;
        this.committeeHead = committeeHead;
    }

    protected ComitteReponseParcableModel(Parcel in) {
        committeeId = in.readInt();
        committeeTitle = in.readString();
        committeeHead = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(committeeId);
        dest.writeString(committeeTitle);
        dest.writeInt(committeeHead);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ComitteReponseParcableModel> CREATOR = new Creator<ComitteReponseParcableModel>() {
        @Override
        public ComitteReponseParcableModel createFromParcel(Parcel in) {
            return new ComitteReponseParcableModel(in);
        }

        @Override
        public ComitteReponseParcableModel[] newArray(int size) {
            return new ComitteReponseParcableModel[size];
        }
    };

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public String getCommitteeTitle() {
        return committeeTitle;
    }

    public void setCommitteeTitle(String committeeTitle) {
        this.committeeTitle = committeeTitle;
    }

    public int getCommitteeHead() {
        return committeeHead;
    }

    public void setCommitteeHead(int committeeHead) {
        this.committeeHead = committeeHead;
    }
}
