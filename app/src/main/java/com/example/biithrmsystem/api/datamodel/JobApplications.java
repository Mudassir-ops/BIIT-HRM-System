package com.example.biithrmsystem.api.datamodel;

import java.util.List;

public class JobApplications {
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<String> getShortlists() {
        return shortlists;
    }

    public void setShortlists(List<String> shortlists) {
        this.shortlists = shortlists;
    }

    public int getJobApplicationID() {
        return jobApplicationID;
    }

    public void setJobApplicationID(int jobApplicationID) {
        this.jobApplicationID = jobApplicationID;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShortlist() {
        return shortlist;
    }

    public void setShortlist(String shortlist) {
        this.shortlist = shortlist;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    Job job;
    List<String> shortlists;
    int jobApplicationID;
    int jid;
    int uid;
    String name;
    String status;
    String shortlist;
    String documentPath;


}
