package com.example.fcmchat;

public class Contactmodel {
    String name;
    String mobNo;

    public Contactmodel(String name, String mobNo) {
        this.name = name;
        this.mobNo = mobNo;
    }

    public Contactmodel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

}
