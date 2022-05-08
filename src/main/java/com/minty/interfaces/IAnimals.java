package com.minty.interfaces;

import com.minty.models.Animals;

import java.util.List;

public interface IAnimals {
    Animals getAnimal(int id);

    List<Animals> getAnimals();

    boolean createAnimal(Animals animal);

    boolean updateAnimal(Animals animal);

    boolean deleteAnimal(int id);
}
