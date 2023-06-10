package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

public class UserSecond {
    @SerializedName("Uid")
    public int uid;
    @SerializedName("Fname")
    public String fname;
    @SerializedName("Lname")
    public String lname;
    public String email;
    public String role;
    public String mobile;
    public String cnic;
    public String dob;
    public String gender;
    public String address;
    public String image;
}
