package com.example.biithrmsystem.api.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AttendanceRecord implements Parcelable {
    public static final Creator<AttendanceRecord> CREATOR = new Creator<AttendanceRecord>() {
        @Override
        public AttendanceRecord createFromParcel(Parcel in) {
            return new AttendanceRecord(in);
        }

        @Override
        public AttendanceRecord[] newArray(int size) {
            return new AttendanceRecord[size];
        }
    };
    public String date;
    public ArrayList<Record> records;

    ;

    public AttendanceRecord() {
    }

    public AttendanceRecord(Parcel in) {
        date = in.readString();
        records = in.createTypedArrayList(Record.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeTypedList(records);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
