package com.android.renly.toilet.api.bean;

public class Position {
    private int id;
    private boolean isUsing;
    private boolean isServing;
    private String start_time;
    private String type;
    private Toilet toilet;

    public Position(boolean isUsing, boolean isServing, String start_time, String type, Toilet toilet) {
        this.isUsing = isUsing;
        this.isServing = isServing;
        this.start_time = start_time;
        this.type = type;
        this.toilet = toilet;
    }

    public Position(int id, boolean isUsing, boolean isServing, String start_time, String type, Toilet toilet) {
        this.id = id;
        this.isUsing = isUsing;
        this.isServing = isServing;
        this.start_time = start_time;
        this.type = type;
        this.toilet = toilet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(boolean isUsing) {
        this.isUsing = isUsing;
    }

    public boolean getIsServing() {
        return isServing;
    }

    public void setIsServing(boolean isServing) {
        this.isServing = isServing;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Toilet getToilet() {
        return toilet;
    }

    public void setToilet(Toilet toilet) {
        this.toilet = toilet;
    }
}
