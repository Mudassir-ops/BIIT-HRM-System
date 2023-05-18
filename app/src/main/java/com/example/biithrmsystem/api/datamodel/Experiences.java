package com.example.biithrmsystem.api.datamodel;

public class Experiences {

    int expID;
    int uid;

    public int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        this.expID = expID;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getCurrentwork() {
        return currentwork;
    }

    public void setCurrentwork(String currentwork) {
        this.currentwork = currentwork;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getOtherskill() {
        return otherskill;
    }

    public void setOtherskill(String otherskill) {
        this.otherskill = otherskill;
    }

    public String getHasexperienced() {
        return hasexperienced;
    }

    public void setHasexperienced(String hasexperienced) {
        this.hasexperienced = hasexperienced;
    }

    String company;
    String title;
    String startdate;
    String currentwork;
    String enddate;
    String otherskill;
    String hasexperienced;


}
