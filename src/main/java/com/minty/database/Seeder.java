package com.minty.database;

import org.sql2o.Connection;

public class Seeder {
    public static void seed(Connection conn) {
        try {
            conn.createQuery("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, " +
                            "username VARCHAR(255) UNIQUE,fullName VARCHAR(255), " +
                            "company VARCHAR(255), password VARCHAR(255))")
                    .executeUpdate();
            conn.createQuery("CREATE TABLE IF NOT EXISTS animals (id SERIAL PRIMARY KEY, " +
                    "animalname VARCHAR(255) UNIQUE, " +
                    "rangerid VARCHAR(255), type TEXT, " +
                    "age TEXT, health VARCHAR(255))").executeUpdate();
            conn.createQuery("CREATE TABLE IF NOT EXISTS sightings " +
                            "(id SERIAL PRIMARY KEY, loc VARCHAR(255), animalid INTEGER, rangerid INTEGER)")
                    .executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Cannot seed database.", e);
        }
    }

    public static void clearDb(Connection conn) {
        try {
            conn.createQuery("DROP TABLE IF EXISTS animals CASCADE").executeUpdate();
            conn.createQuery("DROP TABLE IF EXISTS sightings CASCADE").executeUpdate();
            conn.createQuery("DROP TABLE IF EXISTS users CASCADE").executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Cannot clear database.", e);
        }
    }
}
