package com.example.biithrmsystem.api.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserSignInResponse {

    @SerializedName("educations")
    public ArrayList<Object> educations;
    @SerializedName("jobApplications")
    public ArrayList<Object> jobApplications;
    @SerializedName("leave_Application")
    public ArrayList<Object> leave_Application;
    @SerializedName("experiences")
    public ArrayList<Object> experiences;
    @SerializedName("Uid")
    public int uid;
    @SerializedName("Fname")
    public String fname = "";
    @SerializedName("Lname")
    public String lname;
    @SerializedName("email")
    public String email;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("cnic")
    public String cnic;
    @SerializedName("dob")
    public String dob;
    @SerializedName("gender")
    public String gender;
    @SerializedName("address")
    public String address;
    @SerializedName("password")
    public String password;
    @SerializedName("role")
    public String role;
    @SerializedName("image")
    public String image;

}
