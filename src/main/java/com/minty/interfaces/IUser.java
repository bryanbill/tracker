package com.minty.interfaces;

import com.minty.models.User;
import org.sql2o.Connection;


public interface IUser {
    User login(Connection conn, String username, String password);

    User getUser(Connection conn, String username);

    User getUserById(Connection conn, int id);

    boolean createUser(Connection conn, User user);

    boolean deleteUser(Connection conn, String username);

    boolean updateUser(Connection conn, User user);
}
