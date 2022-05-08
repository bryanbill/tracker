package com.minty.dao;

import com.minty.interfaces.IUser;
import com.minty.models.User;
import org.sql2o.Connection;

public class UserDao implements IUser {

    /**
     * @param conn
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(Connection conn, String username, String password) {
        try {
            return conn.createQuery("SELECT * FROM users " +
                            "WHERE username = :username AND password = :password")
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeAndFetchFirst(User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param conn
     * @param username
     * @return
     */
    @Override
    public User getUser(Connection conn, String username) {
        try {
            return conn.createQuery("SELECT * FROM users " +
                            "WHERE username = :username")
                    .addParameter("username", username)
                    .executeAndFetchFirst(User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param conn
     * @param id
     * @return
     */
    @Override
    public User getUserById(Connection conn, int id) {
        try {
            return conn.createQuery("SELECT * FROM users " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @param username
     * @return
     */
    @Override
    public boolean deleteUser(Connection conn, String username) {
        try {
            return conn.createQuery("DELETE FROM users WHERE username = :username")
                    .addParameter("username", username)
                    .executeUpdate().getResult() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param conn
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(Connection conn, User user) {
        try {
            return conn.createQuery("UPDATE users SET fullname = :fullName WHERE username = :username")
                    .bind(user)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
