package com.example.myapplication;

public class Donut {
    private String ID;
    private String NAME;
    private String FAMILYNAME;
    private String Email;
    private String Phone;

    public Donut() {
    }
    public Donut(String ID, String NAME, String FAMILYNAME, String email, String phone) {
        this.ID = ID;
        this.NAME = NAME;
        this.FAMILYNAME = FAMILYNAME;
        Email = email;
        Phone = phone;
    }

    public Donut(String NAME, String FAMILYNAME, String email, String phone) {
        this.NAME = NAME;
        this.FAMILYNAME = FAMILYNAME;
        Email = email;
        Phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFAMILYNAME() {
        return FAMILYNAME;
    }

    public void setFAMILYNAME(String FAMILYNAME) {
        this.FAMILYNAME = FAMILYNAME;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
