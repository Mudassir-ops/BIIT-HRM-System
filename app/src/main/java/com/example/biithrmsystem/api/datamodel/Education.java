package com.example.biithrmsystem.api.datamodel;

public class Education {

    int Uid = 8;
    String Institute = "";
    String Degree = "";
    String Board = "";
    String Startdate = "";
    String Enddate = "";
    String hasaddededucation = "";

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getInstitute() {
        return Institute;
    }

    public void setInstitute(String institute) {
        Institute = institute;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
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
}
