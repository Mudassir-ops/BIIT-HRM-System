package com.example.biithrmsystem.adapter;

public class Employees {
    int srcImg;
    String title;

    public Employees(int srcImg, String title) {
        this.srcImg = srcImg;
        this.title = title;
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
}
