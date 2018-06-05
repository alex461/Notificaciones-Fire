package com.example.alex.notification_fire;

public class Model1 {

    private String id;
    private String tittle;
    private String description;
    private String descount;

    public Model1() {
    }

    public Model1(String id, String tittle, String description, String descount) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.descount = descount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescount() {
        return descount;
    }

    public void setDescount(String descount) {
        this.descount = descount;
    }
}
