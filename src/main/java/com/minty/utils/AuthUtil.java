package com.minty.utils;

import spark.Request;
import spark.Response;

public class AuthUtil {
    protected static void checkLoggedIn(Request request, Response response) {
        // Check if the user is loggedIn in
        if (request.session().attribute("user") == null) {
            // Redirect to login page
            response.redirect("/login");
        }
    }
}
