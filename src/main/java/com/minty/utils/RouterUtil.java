package com.minty.utils;

import com.minty.dao.AnimalsDao;
import com.minty.dao.SightingDao;
import com.minty.dao.UserDao;
import spark.Request;
import spark.Response;

public class RouterUtil {
    protected static void checkLoggedIn(Request request, Response response) {
        // Check if the user is loggedIn in
        if (request.session().attribute("user") == null) {
            // Redirect to login page
            response.redirect("/login");
        }
    }
}
