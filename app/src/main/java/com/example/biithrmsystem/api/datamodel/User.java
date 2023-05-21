package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class User {

    List<String> educations;
    List<JobApplications> jobApplications;
    List<String> leave_Application;
    List<Experiences> experiences;
    int uid;
    String fname;
    String lname;
    String email;
    //    @JsonIgnore
//    int mobile;
    String cnic;
    String dob;
    String gender;
    String address;
    String password;
    String role;
    String image;

    public List<String> getEducations() {
        return educations;
    }

    public void setEducations(List<String> educations) {
        this.educations = educations;
    }

    public List<JobApplications> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplications> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public List<String> getLeave_Application() {
        return leave_Application;
    }

    public void setLeave_Application(List<String> leave_Application) {
        this.leave_Application = leave_Application;
    }

    public List<Experiences> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experiences> experiences) {
        this.experiences = experiences;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

//    public int getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(int mobile) {
//        this.mobile = mobile;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
