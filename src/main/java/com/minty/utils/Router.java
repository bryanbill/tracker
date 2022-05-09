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

import java.util.*;

import static spark.Spark.*;
import static spark.SparkBase.staticFileLocation;

public class Router extends RouterUtil {
    public static void route(Connection connection) {
        UserDao userDao = new UserDao();
        AnimalsDao animalsDao = new AnimalsDao();
        SightingDao sightingsDao = new SightingDao();

        staticFileLocation("/public");
        get("/", (req, res) -> {
            checkLoggedIn(req, res);
            Map<String, Object> model = new HashMap<>();
            List<Sightings> sightings = sightingsDao.getSightings(connection);
            List<Animals> animals = animalsDao.getAnimals(connection);
            model.put("sightings", sightings);
            model.put("animals", animals);
            model.put("user", User.getCurrentUser());
            model.put("totalAnimals", animals.size());
            model.put("totalSightings", sightings.size());
            return new ModelAndView(model, "index.hbs");
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
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = animalsDao.getAnimals(connection);
            model.put("animals", animals);
            model.put("sightings", sightingsDao.getSightings(connection));
            model.put("user", User.getCurrentUser());
            model.put("totalSightings", sightingsDao.getSightings(connection).size());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (req, res) -> {
            checkLoggedIn(req, res);
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = animalsDao.getAnimals(connection);
            model.put("animals", animals);
            model.put("user", User.getCurrentUser());
            model.put("totalAnimals", animals.size());
            List<Animals> s = new ArrayList<>();
            if (animals.size() > 0) {
                // Filter animals where type is "endangered"

                for (Animals a : animals) {
                    if (a.getAnimalType().equals("endangered")) {
                        System.out.println(a.getAnimalName());
                        s.add(a);
                    }
                }

            }
            System.out.println(animals.size());
            model.put("endangered", s.size());
            model.put("ratio", (double) s.size() / animals.size());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            User user = userDao.login(connection, username, password);
            if (user != null) {
                req.session().attribute("user", user);
                res.redirect("/");
                return "Logged in";
            }
            res.redirect("/");
            return "Login failed";

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
            String animalName = req.queryParams("animalName");
            String animalType = req.queryParams("animalType");
            String age = req.queryParams("age");
            String health = req.queryParams("health");
            User user = req.session().attribute("user");
            animalsDao.createAnimal(connection,
                    new Animals(animalName, animalType, age, health, user.getId(),
                            new Date()));
            res.redirect("/animals");
            return "New Animal";
        });

        post("/new/sighting", (req, res) -> {
            checkLoggedIn(req, res);
            String animalId = req.queryParams("animalName");
            String sightingLocation = req.queryParams("location");
            User user = (User) req.session().attribute("user");
            sightingsDao.createSighting(connection,
                    new Sightings(sightingLocation,
                            animalId, user.getFullName()));
            res.redirect("/sightings");
            return "New Sighting";
        });

        delete("/delete/animal/:id", (req, res) -> {
            checkLoggedIn(req, res);
            int id = Integer.parseInt(req.params("id"));
            animalsDao.deleteAnimal(connection, id);
            res.redirect("/animals");
            return "Animal Deleted";
        });

        delete("/delete/sighting/:id", (req, res) -> {
            checkLoggedIn(req, res);
            int id = Integer.parseInt(req.params("id"));
            sightingsDao.deleteSighting(connection, id);
            res.redirect("/sightings");
            return "Sighting Deleted";
        });

    }
}
