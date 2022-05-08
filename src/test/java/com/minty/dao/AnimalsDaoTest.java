package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Animals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

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
                            "Young", "Healthy")));
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
                            "Young", "Healthy"));
            animalsDao.createAnimal(conn, new Animals("DuckBilled Platypus",
                    "Rare", "Old", "sickly"));
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
                            "Young", "Healthy")));
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
                            "Young", "Healthy"));
            assertTrue(animalsDao.deleteAnimal(conn, 1));
        } catch (Exception e) {
            throw new RuntimeException("Test Error", e);
        }
    }
}