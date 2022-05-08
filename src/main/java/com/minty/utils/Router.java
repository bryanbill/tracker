package com.minty.utils;

import com.minty.dao.AnimalsDao;
import com.minty.dao.SightingDao;
import com.minty.dao.UserDao;
import com.minty.models.Animals;
import com.minty.models.Sightings;
import com.minty.models.User;
import org.sql2o.Connection;

import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class Router extends RouterUtil {
    public static void route(Connection connection) {
        UserDao userDao = new UserDao();
        AnimalsDao animalsDao = new AnimalsDao();
        SightingDao sightingsDao = new SightingDao();

        staticFileLocation("/public");
        get("/", (req, res) -> {
            checkLoggedIn(req, res);
            return "Hello World";
        });

        get("/login", (req, res) -> {
            return "Login";
        });

        get("/register", (req, res) -> {
            return "Register";
        });

        get("/logout", (req, res) -> {
            req.session().invalidate();
            return "Logged out";
        });

        get("/sightings", (req, res) -> {
            checkLoggedIn(req, res);
            return sightingsDao.getSightings(connection);
        });

        get("/animals", (req, res) -> {
            checkLoggedIn(req, res);
            return animalsDao.getAnimals(connection);
        });

        get("/new/animal", (req, res) -> {
            checkLoggedIn(req, res);
            return "New Animal";
        });

        get("/new/sighting", (req, res) -> {
            checkLoggedIn(req, res);
            return "New Sighting";
        });

        get("/ranger/:id", (req, res) -> {
            checkLoggedIn(req, res);
            return "Ranger";
        });

        get("/animal/:id", (req, res) -> {
            checkLoggedIn(req, res);
            return "Animal";
        });

        get("/sighting/:id", (req, res) -> {
            checkLoggedIn(req, res);
            return "Sighting";
        });

        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            User user = userDao.login(connection, username, password);
            req.session().attribute("user", user);
            return "Logged in";
        });
        post("/new/animal", (req, res) -> {
            checkLoggedIn(req, res);
            String animalName = req.queryParams("name");
            String animalType = req.queryParams("animalType");
            String age = req.queryParams("age");
            String health = req.queryParams("health");
            User user = (User) req.session().attribute("user");
            animalsDao.createAnimal(connection,
                    new Animals(animalName, animalType, age, health, user.getId(),
                            new Date()));
            return "New Animal";
        });

        post("/new/sighting", (req, res) -> {
            checkLoggedIn(req, res);
            int animalId = Integer.parseInt(req.queryParams("animalId"));
            String sightingLocation = req.queryParams("sightingLocation");
            User user = (User) req.session().attribute("user");

            sightingsDao.createSighting(connection,
                    new Sightings(sightingLocation,
                            animalId, user.getId()));

            return "New Sighting";
        });

    }
}
