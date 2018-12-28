package com.android.renly.toilet.api.bean;

public class Toilet {
    private int id;
    private String name;
    private String type;
    private Cleaner cleaner;
    private String last_cleaned_time;
    private String next_clean_time;
    private boolean isService;
    private Floor floor;

    public Toilet(String name, String type, Cleaner cleaner,
                  String last_cleaned_time, String next_clean_time, boolean isService, Floor floor) {
        this.name = name;
        this.type = type;
        this.cleaner = cleaner;
        this.last_cleaned_time = last_cleaned_time;
        this.next_clean_time = next_clean_time;
        this.isService = isService;
        this.floor = floor;
    }

    public Toilet(int id, String name, String type, Cleaner cleaner,
                  String last_cleaned_time, String next_clean_time, boolean isService, Floor floor) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cleaner = cleaner;
        this.last_cleaned_time = last_cleaned_time;
        this.next_clean_time = next_clean_time;
        this.isService = isService;
        this.floor = floor;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public String getLast_cleaned_time() {
        return last_cleaned_time;
    }

    public void setLast_cleaned_time(String last_cleaned_time) {
        this.last_cleaned_time = last_cleaned_time;
    }

    public String getNext_clean_time() {
        return next_clean_time;
    }

    public void setNext_clean_time(String next_clean_time) {
        this.next_clean_time = next_clean_time;
    }

    public boolean getIsService() {
        return isService;
    }

    public void setIsService(boolean isService) {
        this.isService = isService;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
