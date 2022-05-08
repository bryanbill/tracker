package com.minty.interfaces;

import com.minty.models.Sightings;

import java.util.List;

public interface ISightings {
    Sightings getSighting(int id);

    List<Sightings> getSightings();

    boolean createSighting(Sightings sighting);

    boolean updateSighting(Sightings sighting);

    boolean deleteSighting(int id);
}
