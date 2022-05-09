package com.minty.models;

public class Sightings {
    private int id;
    private String loc;
    private String animalId;
    private String rangerId;

    public Sightings(String loc, String animalId, String rangerId) {
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

    public String getAnimalId() {
        return animalId;
    }

    public String getRangerId() {
        return rangerId;
    }
}
