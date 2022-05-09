package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Sightings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SightingDaoTest {

    Connection conn;

    @BeforeEach
    void setUp() {
        try {
            conn = Db.connect();

            Seeder.seed(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown() {
        Seeder.clearDb(conn);
    }

    @Test
    void getSighting() {
        try {
            SightingDao sightingDao = new SightingDao();
            assertTrue(sightingDao.createSighting(conn, new Sightings("Hilly Hills", "Hill Billy", "Juma")));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void getSightings() {
        try {
            SightingDao sightingDao = new SightingDao();
            sightingDao.createSighting(conn, new Sightings("Hilly Hills", "Hill Billy", "Juma"));
            sightingDao.createSighting(conn, new Sightings("Hilly Hills", "2", "2"));
            List<Sightings> sightings = sightingDao.getSightings(conn);
            assertEquals(2, sightings.size());
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void createSighting() {
        try {
            SightingDao sightingDao = new SightingDao();
            sightingDao.createSighting(conn, new Sightings("Hilly Hills", "Hill Billy", "Juma"));
            Sightings sighting = sightingDao.getSighting(conn, 1);
            assertEquals(1, sighting.getId());
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void updateSighting() {
        try {
            SightingDao sightingDao = new SightingDao();
            boolean ts = sightingDao.createSighting(conn, new Sightings("Hilly Hills", "Hill Billy", "Juma"));
            boolean res = sightingDao.updateSighting(conn,
                    new Sightings("Jumbo Hills", "Hill Billy", "Juma"), 1);
            assertTrue(ts && res);
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void deleteSighting() {
        try {
            SightingDao sightingDao = new SightingDao();
            sightingDao.createSighting(conn, new Sightings("Hilly Hills", "Hill Billy", "Juma"));
            assertTrue(sightingDao.deleteSighting(conn, 1));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }
}