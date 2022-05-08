package com.minty.interfaces;

import com.minty.models.Sightings;
import org.sql2o.Connection;

import java.util.List;

public interface ISightings {
    Sightings getSighting(Connection conn, int id);

    List<Sightings> getSightings(Connection conn);

    boolean createSighting(Connection conn,Sightings sighting);

    boolean updateSighting(Connection conn,Sightings sighting, int id);

    boolean deleteSighting(Connection conn,int id);
}
