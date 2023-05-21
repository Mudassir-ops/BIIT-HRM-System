package com.example.biithrmsystem.api.datamodel;

public class ApplyJobModel {

    int jId, Uid;
    String DocumentPath;

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getDocumentPath() {
        return DocumentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.DocumentPath = documentPath;
    }
}
