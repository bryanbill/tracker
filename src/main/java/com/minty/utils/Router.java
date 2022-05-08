package com.minty.utils;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class Router extends AuthUtil {
    public static void route() {
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


        post("/new/animal", (req, res) -> {
            checkLoggedIn(req, res);
            return "New Animal";
        });

        post("/new/sighting", (req, res) -> {
            checkLoggedIn(req, res);
            return "New Sighting";
        });

    }
}
