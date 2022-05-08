package com.minty;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.utils.Router;
import org.sql2o.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Db().connect();
        Seeder.seed(connection);
        Router.route(connection);
    }
}