package com.domain;

public class Reader {
   private int rdID;
   private String rdName;
   private String rdSex;

   private String rdDept;
   private String rdPhone;
   private String rdEmail;
   private String rdDateReg;
   private String rdPhoto;
   private String rdStatus;
   private int rdBorrowQty;
   private String rdPwd;
   private String rdLeibie;

    @Override
    public String toString() {
        return "Reader{" +
                "rdID=" + rdID +
                ", rdName='" + rdName + '\'' +
                ", rdSex='" + rdSex + '\'' +
                ", rdDept='" + rdDept + '\'' +
                ", rdPhone='" + rdPhone + '\'' +
                ", rdEmail='" + rdEmail + '\'' +
                ", rdDateReg='" + rdDateReg + '\'' +
                ", rdPhoto='" + rdPhoto + '\'' +
                ", rdStatus='" + rdStatus + '\'' +
                ", rdBorrowQty=" + rdBorrowQty +
                ", rdPwd='" + rdPwd + '\'' +
                ", rdLeibie='" + rdLeibie + '\'' +
                '}';
    }

    public String getRdLeibie() {
        return rdLeibie;
    }

    public void setRdLeibie(String rdLeibie) {
        this.rdLeibie = rdLeibie;
    }

    public int getRdID() {
        return rdID;
    }

    public void setRdID(int rdID) {
        this.rdID = rdID;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdSex() {
        return rdSex;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
    }


    public String getRdDept() {
        return rdDept;
    }

    public void setRdDept(String rdDept) {
        this.rdDept = rdDept;
    }

    public String getRdPhone() {
        return rdPhone;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public String getRdDateReg() {
        return rdDateReg;
    }

    public void setRdDateReg(String rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public String getRdPhoto() {
        return rdPhoto;
    }

    public void setRdPhoto(String rdPhoto) {
        this.rdPhoto = rdPhoto;
    }

    public String getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(String rdStatus) {
        this.rdStatus = rdStatus;
    }

    public int getRdBorrowQty() {
        return rdBorrowQty;
    }

    public void setRdBorrowQty(int rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }


}
