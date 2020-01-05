package com.domain;

public class Book {

  private int bkID;
  private String   bkCode;
  private String bkName;
  private int bkNum;
  private String bkAuthor;
  private String bkPress;
  private String  bkDatePress;
  private String bkLanguage;
  private int  bkPages;
  private String bkDateIn;
  private String bkBrief;
  private String bkCover;
  private String bkStatus;
  private String bkLeibie;

    public int getBkNum() {
        return bkNum;
    }

    public void setBkNum(int bkNum) {
        this.bkNum = bkNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkID=" + bkID +
                ", bkCode='" + bkCode + '\'' +
                ", bkName='" + bkName + '\'' +
                ", bkNum=" + bkNum +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPress='" + bkPress + '\'' +
                ", bkDatePress='" + bkDatePress + '\'' +
                ", bkLanguage=" + bkLanguage +
                ", bkPages=" + bkPages +
                ", bkDateIn='" + bkDateIn + '\'' +
                ", bkBrief='" + bkBrief + '\'' +
                ", bkCover='" + bkCover + '\'' +
                ", bkStatus='" + bkStatus + '\'' +
                ", bkLeibie='" + bkLeibie + '\'' +
                '}';
    }

    public String getBkLeibie() {
        return bkLeibie;
    }

    public void setBkLeibie(String bkLeibie) {
        this.bkLeibie = bkLeibie;
    }

    public int getBkID() {
        return bkID;
    }

    public void setBkID(int bkID) {
        this.bkID = bkID;
    }

    public String getBkCode() {
        return bkCode;
    }

    public void setBkCode(String bkCode) {
        this.bkCode = bkCode;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public String getBkDatePress() {
        return bkDatePress;
    }

    public void setBkDatePress(String bkDatePress) {
        this.bkDatePress = bkDatePress;
    }


    public String getBkLanguage() {
        return bkLanguage;
    }

    public void setBkLanguage(String bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public int getBkPages() {
        return bkPages;
    }

    public void setBkPages(int bkPages) {
        this.bkPages = bkPages;
    }

    public String getBkDateIn() {
        return bkDateIn;
    }

    public void setBkDateIn(String bkDateIn) {
        this.bkDateIn = bkDateIn;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public String getBkCover() {
        return bkCover;
    }

    public void setBkCover(String bkCover) {
        this.bkCover = bkCover;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
    }
}
