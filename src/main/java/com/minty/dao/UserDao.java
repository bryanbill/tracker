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
        return null;
    }

    /**
     * @param conn
     * @param username
     * @return
     */
    @Override
    public User getUser(Connection conn, String username) {
        return null;
    }

    /**
     * @param conn
     * @param id
     * @return
     */
    @Override
    public User getUserById(Connection conn, int id) {
        return null;
    }

    /**
     * @param conn
     * @param username
     * @return
     */
    @Override
    public boolean deleteUser(Connection conn, String username) {
        return false;
    }

    /**
     * @param conn
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(Connection conn, User user) {
        return false;
    }
}
