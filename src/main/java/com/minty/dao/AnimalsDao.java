package com.minty.dao;

import com.minty.interfaces.IAnimals;
import com.minty.models.Animals;
import org.sql2o.Connection;

import java.util.List;

public class AnimalsDao implements IAnimals {
    /**
     * @param conn
     * @param id
     * @return
     */
    @Override
    public Animals getAnimal(Connection conn, int id) {
        try {
            return conn.createQuery("SELECT * FROM animals " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @return
     */
    @Override
    public List<Animals> getAnimals(Connection conn) {
        try {
            return conn.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animals.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @param animal
     * @return
     */
    @Override
    public boolean createAnimal(Connection conn, Animals animal) {
        try {
            return conn.createQuery("INSERT INTO animals (animalname, animaltype, age,health)"
                            + "VALUES (:animalName, :animalType, :age, :health)")
                    .bind(animal)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @param animal
     * @return
     */
    @Override
    public boolean updateAnimal(Connection conn, Animals animal) {
        try {
            return conn.createQuery("UPDATE animals SET animalname = :animalName, " +
                            "animaltype = :animalType, age = :age, " +
                            "health = :health WHERE id = :id")
                    .bind(animal)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @param id
     * @return
     */
    @Override
    public boolean deleteAnimal(Connection conn, int id) {
        try {
            return conn.createQuery("DELETE FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
