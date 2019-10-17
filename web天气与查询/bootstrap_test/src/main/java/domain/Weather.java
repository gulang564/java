package main.java.domain;

public class Weather {

   String City_ID ;
   String City_EN;
   String City_CN;
   String Country_code;
   String Country_EN;
   String Country_CN;
   String Province_EN;
   String Province_CN;
   String Admin_district_EN;
   String Admin_district_CN;
   float Latitude;
   float Longitude;
   String AD_code;

    public String getCity_ID() {
        return City_ID;
    }

    public void setCity_ID(String city_ID) {
        City_ID = city_ID;
    }

    public String getCity_EN() {
        return City_EN;
    }

    public void setCity_EN(String city_EN) {
        City_EN = city_EN;
    }

    public String getCity_CN() {
        return City_CN;
    }

    public void setCity_CN(String city_CN) {
        City_CN = city_CN;
    }

    public String getCountry_code() {
        return Country_code;
    }

    public void setCountry_code(String country_code) {
        Country_code = country_code;
    }

    public String getCountry_EN() {
        return Country_EN;
    }

    public void setCountry_EN(String country_EN) {
        Country_EN = country_EN;
    }

    public String getCountry_CN() {
        return Country_CN;
    }

    public void setCountry_CN(String country_CN) {
        Country_CN = country_CN;
    }

    public String getProvince_EN() {
        return Province_EN;
    }

    public void setProvince_EN(String province_EN) {
        Province_EN = province_EN;
    }

    public String getProvince_CN() {
        return Province_CN;
    }

    public void setProvince_CN(String province_CN) {
        Province_CN = province_CN;
    }

    public String getAdmin_district_EN() {
        return Admin_district_EN;
    }

    public void setAdmin_district_EN(String admin_district_EN) {
        Admin_district_EN = admin_district_EN;
    }

    public String getAdmin_district_CN() {
        return Admin_district_CN;
    }

    public void setAdmin_district_CN(String admin_district_CN) {
        Admin_district_CN = admin_district_CN;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public String getAD_code() {
        return AD_code;
    }

    public void setAD_code(String AD_code) {
        this.AD_code = AD_code;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "City_ID='" + City_ID + '\'' +
                ", City_EN='" + City_EN + '\'' +
                ", City_CN='" + City_CN + '\'' +
                ", Country_code='" + Country_code + '\'' +
                ", Country_EN='" + Country_EN + '\'' +
                ", Country_CN='" + Country_CN + '\'' +
                ", Province_EN='" + Province_EN + '\'' +
                ", Province_CN='" + Province_CN + '\'' +
                ", Admin_district_EN='" + Admin_district_EN + '\'' +
                ", Admin_district_CN='" + Admin_district_CN + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", AD_code='" + AD_code + '\'' +
                '}';
    }
}
