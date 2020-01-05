package com.domain;

public class ZongHe {
 private  int bookID;
 private  String bookName;
 private  String bookAuth;
 private  int xujiecishu;
 private  String jieyueriqi;
 private  String yinghuanriqi;
 private  int chaoqitianshu;
 private  double chaoqijinge;

    @Override
    public String toString() {
        return "ZongHe{" +
                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuth='" + bookAuth + '\'' +
                ", xujiecishu='" + xujiecishu + '\'' +
                ", jieyueriqi='" + jieyueriqi + '\'' +
                ", yinghuanriqi='" + yinghuanriqi + '\'' +
                ", chaoqitianshu=" + chaoqitianshu +
                ", chaoqijinge=" + chaoqijinge +
                '}';
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }


    public int getXujiecishu() {
        return xujiecishu;
    }

    public void setXujiecishu(int xujiecishu) {
        this.xujiecishu = xujiecishu;
    }

    public String getJieyueriqi() {
        return jieyueriqi;
    }

    public void setJieyueriqi(String jieyueriqi) {
        this.jieyueriqi = jieyueriqi;
    }

    public String getYinghuanriqi() {
        return yinghuanriqi;
    }

    public void setYinghuanriqi(String yinghuanriqi) {
        this.yinghuanriqi = yinghuanriqi;
    }

    public int getChaoqitianshu() {
        return chaoqitianshu;
    }

    public void setChaoqitianshu(int chaoqitianshu) {
        this.chaoqitianshu = chaoqitianshu;
    }

    public double getChaoqijinge() {
        return chaoqijinge;
    }

    public void setChaoqijinge(double chaoqijinge) {
        this.chaoqijinge = chaoqijinge;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
