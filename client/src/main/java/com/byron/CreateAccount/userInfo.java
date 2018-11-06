package com.byron.CreateAccount;


public class userInfo {

    String firstname;
    String lastname;
    String country;
    String day;
    String month;
    String username;
    String status;
    String summary;
    String year;

    private static userInfo onlyInstance = null;
    private userInfo() {

    }
    public static userInfo getInstance() {
        if(onlyInstance ==null) {
            onlyInstance = new userInfo();
        }
        return onlyInstance;
    }
    //----------------------Accessors & Mutators -------------------------------//
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getYear() {return year;}

    public void setYear(String year){this.year = year;}
}
