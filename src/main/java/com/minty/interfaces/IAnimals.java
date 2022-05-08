package com.minty.interfaces;

import com.minty.models.Animals;
import org.sql2o.Connection;

import java.util.List;

public interface IAnimals {
    Animals getAnimal(Connection conn, int id);

    List<Animals> getAnimals(Connection conn);

    boolean createAnimal(Connection conn, Animals animal);

    boolean updateAnimal(Connection conn, Animals animal);

    boolean deleteAnimal(Connection conn, int id);
}
