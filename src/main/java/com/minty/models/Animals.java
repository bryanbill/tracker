package com.minty.models;

public class Animals {
    private int id;
    private String animalName;
    private String animalType;
    private String age;
    private String health;

    public Animals(String animalName, String animalType, String age, String health) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.age = age;
        this.health = health;
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
