package com.minty.models;

import java.util.Date;

public class Animals {
    private int id;
    private String animalName;
    private String animalType;
    private String age;
    private String health;

    public int getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    private int createdBy;

    private Date createdAt;

    public Animals(String animalName, String animalType, String age, String health, int createdBy, Date createdAt) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.age = age;
        this.health = health;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }


}
