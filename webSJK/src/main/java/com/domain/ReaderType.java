package com.domain;

public class ReaderType {

  private String  rdTypeName;
  private int  CanLendQty;
  private int  CanLendDay;
  private int  CanContinueTimes;
  private double  PunishRate;
  private int  DateValid;



    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }

    public int getCanLendQty() {
        return CanLendQty;
    }

    public void setCanLendQty(int canLendQty) {
        CanLendQty = canLendQty;
    }

    public int getCanLendDay() {
        return CanLendDay;
    }

    public void setCanLendDay(int canLendDay) {
        CanLendDay = canLendDay;
    }

    public int getCanContinueTimes() {
        return CanContinueTimes;
    }

    public void setCanContinueTimes(int canContinueTimes) {
        CanContinueTimes = canContinueTimes;
    }

    public double getPunishRate() {
        return PunishRate;
    }

    public void setPunishRate(double punishRate) {
        PunishRate = punishRate;
    }

    public int getDateValid() {
        return DateValid;
    }

    public void setDateValid(int dateValid) {
        DateValid = dateValid;
    }
}
