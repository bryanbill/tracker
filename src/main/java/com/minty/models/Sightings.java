package com.minty.models;

public class Sightings {
    private int id;
    private String loc;
    private Integer animalId;
    private Integer rangerId;

    public Sightings(String loc, Integer animalId, Integer rangerId) {
        this.loc = loc;
        this.animalId = animalId;
        this.rangerId = rangerId;
    }

    public int getId() {
        return id;
    }

    public String getLoc() {
        return loc;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public Integer getRangerId() {
        return rangerId;
    }
}
