package com.minty.database;


import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Db {
    public static Connection connect() {
        System.out.println("Connecting to database...");
        try {
            return new Sql2o("jdbc:postgresql://localhost:5432/minty", "bill", "<cocoginger45").open();
        } catch (Exception exception) {
          throw new RuntimeException("Cannot connect to database.", exception);
        }
    }

}
