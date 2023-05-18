package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class AllJobsReponse {
    Job Job;
    List<String> Shortlists;
    User User;
    int JobApplicationID;
    int Jid;
    int Uid;
    String Name;
    String Status;
    String Shortlist;
    String DocumentPath;

    public com.example.biithrmsystem.api.datamodel.Job getJob() {
        return Job;
    }

    public void setJob(com.example.biithrmsystem.api.datamodel.Job job) {
        Job = job;
    }

    public List<String> getShortlists() {
        return Shortlists;
    }

    public void setShortlists(List<String> shortlists) {
        Shortlists = shortlists;
    }

    public com.example.biithrmsystem.api.datamodel.User getUser() {
        return User;
    }

    public void setUser(com.example.biithrmsystem.api.datamodel.User user) {
        User = user;
    }

    public int getJobApplicationID() {
        return JobApplicationID;
    }

    public void setJobApplicationID(int jobApplicationID) {
        JobApplicationID = jobApplicationID;
    }

    public int getJid() {
        return Jid;
    }

    public void setJid(int jid) {
        Jid = jid;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getShortlist() {
        return Shortlist;
    }

    public void setShortlist(String shortlist) {
        Shortlist = shortlist;
    }

    public String getDocumentPath() {
        return DocumentPath;
    }

    public void setDocumentPath(String documentPath) {
        DocumentPath = documentPath;
    }
}
