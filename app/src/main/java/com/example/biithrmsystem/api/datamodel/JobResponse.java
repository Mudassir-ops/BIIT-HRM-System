package com.example.biithrmsystem.api.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class JobResponse {

    @JsonProperty("JobApplications")
    public ArrayList<JobApplication> jobApplications;
    @JsonProperty("Jid")
    public int jid;
    @JsonProperty("Title")
    public String title;
    public String qualification;
    @JsonProperty("Salary")
    public String salary;
    public String experience;
    @JsonProperty("LastDateOfApply")
    public String lastDateOfApply;
    @JsonProperty("Location")
    public String location;
    @JsonProperty("Description")
    public String description;
    public int noofvacancie;



//    List<String> JobApplications;
//    int Jid;
//    String Title;
//    String Description;
//    String qualification;
//    String experience;
//    String Salary;
//    String LastDateOfApply;
//    String Location;
//    String noofvacancie;

    public JobResponse() {
    }

    public ArrayList<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(ArrayList<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLastDateOfApply() {
        return lastDateOfApply;
    }

    public void setLastDateOfApply(String lastDateOfApply) {
        this.lastDateOfApply = lastDateOfApply;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoofvacancie() {
        return noofvacancie;
    }

    public void setNoofvacancie(int noofvacancie) {
        this.noofvacancie = noofvacancie;
    }
//
//    public Job(List<String> jobApplications, int jid, String title, String description, String salary, String lastDateOfApply, String location) {
//        JobApplications = jobApplications;
//        Jid = jid;
//        Title = title;
//        Description = description;
//        Salary = salary;
//        LastDateOfApply = lastDateOfApply;
//        Location = location;
//    }
//
//    public List<String> getJobApplications() {
//        return JobApplications;
//    }
//
//    public void setJobApplications(List<String> jobApplications) {
//        JobApplications = jobApplications;
//    }
//
//    public int getJid() {
//        return Jid;
//    }
//
//    public void setJid(int jid) {
//        Jid = jid;
//    }
//
//    public String getTitle() {
//        return Title;
//    }
//
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }
//
//    public String getSalary() {
//        return Salary;
//    }
//
//    public void setSalary(String salary) {
//        Salary = salary;
//    }
//
//    public String getLastDateOfApply() {
//        return LastDateOfApply;
//    }
//
//    public void setLastDateOfApply(String lastDateOfApply) {
//        LastDateOfApply = lastDateOfApply;
//    }
//
//    public String getLocation() {
//        return Location;
//    }
//
//    public void setLocation(String location) {
//        Location = location;
//    }
//
//    public String getExperience() {
//        return experience;
//    }
//
//    public void setExperience(String experience) {
//        this.experience = experience;
//    }
//
//    public String getNoofvacancie() {
//        return noofvacancie;
//    }
//
//    public void setNoofvacancie(String noofvacancie) {
//        this.noofvacancie = noofvacancie;
//    }
//
//    public String getQualification() {
//        return qualification;
//    }
//
//    public void setQualification(String qualification) {
//        this.qualification = qualification;
//    }

}
