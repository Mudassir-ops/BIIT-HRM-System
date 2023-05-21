package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class Job {

    List<String> JobApplications;
    int Jid;
    String Title;
    String Description;
    String qualification;
    String experience;
    String Salary;
    String LastDateOfApply;
    String Location;
    String noofvacancie;

    public Job() {
    }

    public Job(List<String> jobApplications, int jid, String title, String description, String salary, String lastDateOfApply, String location) {
        JobApplications = jobApplications;
        Jid = jid;
        Title = title;
        Description = description;
        Salary = salary;
        LastDateOfApply = lastDateOfApply;
        Location = location;
    }

    public List<String> getJobApplications() {
        return JobApplications;
    }

    public void setJobApplications(List<String> jobApplications) {
        JobApplications = jobApplications;
    }

    public int getJid() {
        return Jid;
    }

    public void setJid(int jid) {
        Jid = jid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getLastDateOfApply() {
        return LastDateOfApply;
    }

    public void setLastDateOfApply(String lastDateOfApply) {
        LastDateOfApply = lastDateOfApply;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNoofvacancie() {
        return noofvacancie;
    }

    public void setNoofvacancie(String noofvacancie) {
        this.noofvacancie = noofvacancie;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}
