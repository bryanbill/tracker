package com.minty.dao;

import com.minty.interfaces.ISightings;
import com.minty.models.Sightings;

import java.util.List;

public class SightingDao implements ISightings {

    /**
     * @param id
     * @return
     */
    @Override
    public Sightings getSighting(int id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Sightings> getSightings() {
        return null;
    }

    /**
     * @param sighting
     * @return
     */
    @Override
    public boolean createSighting(Sightings sighting) {
        return false;
    }

    /**
     * @param sighting
     * @return
     */
    @Override
    public boolean updateSighting(Sightings sighting) {
        return false;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteSighting(int id) {
        return false;
    }
}
