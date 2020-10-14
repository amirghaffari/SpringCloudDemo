package com.amirghaffari.springcloud.demo.courseservice;

public class Course {
    private long id;
    private String name;
    private float credit;
    private boolean active;

    public Course() {
    }

    public Course(long id, String name, float credit, boolean active) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.active=active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
