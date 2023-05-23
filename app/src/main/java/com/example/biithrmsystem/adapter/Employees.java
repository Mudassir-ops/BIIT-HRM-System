package com.example.biithrmsystem.adapter;

public class Employees {
    int srcImg;
    String title;
    Boolean isCheckedIn = false;
    String ph0neNO = "false";

    public Employees(int srcImg, String title, Boolean isCheckedIn, String phonNO) {
        this.srcImg = srcImg;
        this.title = title;
        this.isCheckedIn = isCheckedIn;
        this.ph0neNO = phonNO;
    }

    public String getTitle() {
        return title;
    }

    public int getSrcImg() {
        return srcImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSrcImg(int srcImg) {
        this.srcImg = srcImg;
    }


    public Boolean getCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    public String getPh0neNO() {
        return ph0neNO;
    }

    public void setPh0neNO(String ph0neNO) {
        this.ph0neNO = ph0neNO;
    }
}
