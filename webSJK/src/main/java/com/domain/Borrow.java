package com.domain;

public class Borrow {

  private int  rdID;
  private int  bkID;
  private int  ldContinueTimes;
  private String  ldDateOut;
  private String  ldDateRetPlan;

    public int getRdID() {
        return rdID;
    }

    public void setRdID(int rdID) {
        this.rdID = rdID;
    }

    public int getBkID() {
        return bkID;
    }

    public void setBkID(int bkID) {
        this.bkID = bkID;
    }

    public int getLdContinueTimes() {
        return ldContinueTimes;
    }

    public void setLdContinueTimes(int ldContinueTimes) {
        this.ldContinueTimes = ldContinueTimes;
    }

    public String getLdDateOut() {
        return ldDateOut;
    }

    public void setLdDateOut(String ldDateOut) {
        this.ldDateOut = ldDateOut;
    }

    public String getLdDateRetPlan() {
        return ldDateRetPlan;
    }

    public void setLdDateRetPlan(String ldDateRetPlan) {
        this.ldDateRetPlan = ldDateRetPlan;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "rdID=" + rdID +
                ", bkID=" + bkID +
                ", ldContinueTimes=" + ldContinueTimes +
                ", ldDateOut='" + ldDateOut + '\'' +
                ", ldDateRetPlan='" + ldDateRetPlan + '\'' +
                '}';
    }
}
