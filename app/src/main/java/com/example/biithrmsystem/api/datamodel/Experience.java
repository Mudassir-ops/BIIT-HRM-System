package com.example.biithrmsystem.api.datamodel;

public class Experience {

    int Uid = 8;
    String Company = "";
    String Title = "";
    String Startdate = "";
    String Enddate = "";
    String currentwork = "";
    String otherskill = "";
    String hasaddededucation = "";

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }


    public String getStartdate() {
        return Startdate;
    }

    public void setStartdate(String startdate) {
        Startdate = startdate;
    }

    public String getEnddate() {
        return Enddate;
    }

    public void setEnddate(String enddate) {
        Enddate = enddate;
    }

    public String getHasaddededucation() {
        return hasaddededucation;
    }

    public void setHasaddededucation(String hasaddededucation) {
        this.hasaddededucation = hasaddededucation;
    }

    public String getCurrentwork() {
        return currentwork;
    }

    public void setCurrentwork(String currentwork) {
        this.currentwork = currentwork;
    }

    public String getOtherskill() {
        return otherskill;
    }

    public void setOtherskill(String otherskill) {
        this.otherskill = otherskill;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
