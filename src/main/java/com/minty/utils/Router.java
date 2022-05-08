package com.minty.utils;

import com.minty.dao.AnimalsDao;
import com.minty.dao.SightingDao;
import com.minty.dao.UserDao;
import com.minty.models.Animals;
import com.minty.models.Sightings;
import com.minty.models.User;
import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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
            return new ModelAndView(null, "dashboard.hbs");
        }, new HandlebarsTemplateEngine());

        get("/login", (req, res) -> {
            return new ModelAndView(null, "login.hbs");
        }, new HandlebarsTemplateEngine());

        get("/register", (req, res) -> {
            return new ModelAndView(null, "register.hbs");
        }, new HandlebarsTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().invalidate();
            res.redirect("/login");
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
            res.redirect("/");
            return "Logged in";
        });

        post("/register", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            String company = req.queryParams("company");
            String fullName = req.queryParams("fullname");
            userDao.createUser(connection,
                    new User(username, fullName, company, password));
            res.redirect("/login");
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
            res.redirect("/animals");
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
            res.redirect("/sightings");
            return "New Sighting";
        });

    }
}
