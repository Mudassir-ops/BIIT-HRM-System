package com.example.biithrmsystem.api.datamodel;

public class PostJobModel {
    int Jid = 8;
    String Title = "";
    String Description = "";
    int LastDateOfApply = 0;
    String Location = "";
    String Salary = "";

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

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
