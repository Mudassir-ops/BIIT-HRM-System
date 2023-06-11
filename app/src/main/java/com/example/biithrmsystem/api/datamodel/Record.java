package com.example.biithrmsystem.api.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Record implements Parcelable {
    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };
    @SerializedName("Fname")
    public String fname;
    @SerializedName("Uid")
    public int uid;
    public String checkin;
    public String checkout;
    public String status;

    protected Record(Parcel in) {
        fname = in.readString();
        uid = in.readInt();
        checkin = in.readString();
        checkout = in.readString();
        status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeInt(uid);
        dest.writeString(checkin);
        dest.writeString(checkout);
        dest.writeString(status);
    }
}
