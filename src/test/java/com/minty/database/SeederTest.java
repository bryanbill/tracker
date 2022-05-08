package com.minty.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class SeederTest {

    @AfterEach
    void tearDown() {
        try{
            Connection conn = Db.connect();
            assertDoesNotThrow(() -> {
                Seeder.clearDb(conn);
            });
        }catch (Exception e){
            throw new RuntimeException("Cannot connect to database.", e);
        }
    }

    @Test
    void seed() {
        try{
            Connection conn = Db.connect();
             assertDoesNotThrow(() -> {
                 Seeder.seed(conn);
             });
        }catch (Exception e){
            throw new RuntimeException("Cannot connect to database.", e);
        }
    }
}