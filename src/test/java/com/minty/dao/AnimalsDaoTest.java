package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Animals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalsDaoTest {

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
    void getAnimal() {
        try {
            AnimalsDao animalsDao = new AnimalsDao();
            assertTrue(animalsDao.createAnimal(conn,
                    new Animals("Hill Billy", "Rare",
                            "Young", "Healthy", 1, new Date())));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void getAnimals() {
        try {
            AnimalsDao animalsDao = new AnimalsDao();
            animalsDao.createAnimal(conn,
                    new Animals("Hill Billy", "Rare",
                            "Young", "Healthy", 1, new Date()));
            animalsDao.createAnimal(conn, new Animals("DuckBilled Platypus",
                    "Rare", "Old", "sickly", 1, new Date()));
            assertTrue(animalsDao.getAnimals(conn).size() == 2);
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void updateAnimal() {
        try {
            AnimalsDao animalsDao = new AnimalsDao();
            assertTrue(animalsDao.createAnimal(conn,
                    new Animals("Hill Billy", "Rare",
                            "Young", "Healthy", 1, new Date())));
            Animals animal = animalsDao.getAnimal(conn, 1);
            assertTrue(animalsDao.updateAnimal(conn, animal));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }

    @Test
    void deleteAnimal() {
        try {
            AnimalsDao animalsDao = new AnimalsDao();
            animalsDao.createAnimal(conn,
                    new Animals("Hill Billy", "Rare",
                            "Young", "Healthy", 1, new Date()));
            assertTrue(animalsDao.deleteAnimal(conn, 1));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }
}