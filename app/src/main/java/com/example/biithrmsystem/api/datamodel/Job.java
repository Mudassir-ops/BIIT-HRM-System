package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class Job {
    List<String> JobApplications;
    int Jid;
    String Title;
    String Description;
    String Salary;
    int LastDateOfApply;
    String Location;

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

    public int getLastDateOfApply() {
        return LastDateOfApply;
    }

    public void setLastDateOfApply(int lastDateOfApply) {
        LastDateOfApply = lastDateOfApply;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
