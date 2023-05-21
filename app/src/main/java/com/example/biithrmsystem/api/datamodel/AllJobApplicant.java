package com.example.biithrmsystem.api.datamodel;

public class AllJobApplicant {
    int JobApplicationID;
    String Jid;
    int Uid;
    String name;
    String status;
    String DocumentPath;

    public int getJobApplicationID() {
        return JobApplicationID;
    }

    public void setJobApplicationID(int jobApplicationID) {
        JobApplicationID = jobApplicationID;
    }

    public String getJid() {
        return Jid;
    }

    public void setJid(String jid) {
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
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentPath() {
        return DocumentPath;
    }

    public void setDocumentPath(String documentPath) {
        DocumentPath = documentPath;
    }
}
