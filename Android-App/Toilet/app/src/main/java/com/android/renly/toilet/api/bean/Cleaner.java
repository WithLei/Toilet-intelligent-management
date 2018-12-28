package com.android.renly.toilet.api.bean;

public class Cleaner {
    private int id;
    private String name;
    private String phone;
    private String company;

    public Cleaner(String name, String phone, String company) {
        this.name = name;
        this.phone = phone;
        this.company = company;
    }

    public Cleaner(int id, String name, String phone, String company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
