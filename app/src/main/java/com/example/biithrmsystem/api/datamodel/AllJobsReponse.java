package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class AllJobsReponse {
    JobResponse JobResponse;
    List<String> Shortlists;
    User User;
    int JobApplicationID;
    int Jid;
    int Uid;
    String name;
    String status;
    String Shortlist;
    String DocumentPath;

    public JobResponse getJob() {
        return JobResponse;
    }

    public void setJob(JobResponse jobResponse) {
        JobResponse = jobResponse;
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
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
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
