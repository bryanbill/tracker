package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDaoTest {
    Connection conn;

    @BeforeEach
    void setUp() {
        try {
            conn = Db.connect();
            Seeder.seed(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown() {
        Seeder.clearDb(conn);
    }

    @Test
    void getUser() {
        try {
            UserDao userDao = new UserDao();
            assertTrue(userDao.createUser(conn,
                    new User("doe", "John Doe",
                            "Super Rangers", "1234Test")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getUserById() {
        try {
            UserDao userDao = new UserDao();
            assertTrue(userDao.createUser(conn,
                    new User("doe", "John Doe",
                            "Super Rangers", "1234Test")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void deleteUser() {
        try {
            UserDao userDao = new UserDao();
            userDao.createUser(conn,
                    new User("doe", "John Doe",
                            "Super Rangers", "1234Test"));
            assertTrue(userDao.deleteUser(conn,
                    "doe"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateUser() {
        try {
            UserDao userDao = new UserDao();
            userDao.createUser(conn,
                    new User("doe", "John Doe",
                            "Super Rangers", "1234Test"));
            assertTrue(userDao.updateUser(conn, new User("doe", "Jane Doe", "Super Rangers", "1234Test")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}