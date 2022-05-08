package com.minty.interfaces;

import com.minty.models.User;

public interface IUser {
    User login(String username, String password);

    User getUser(String username);

    User getUserById(int id);

    boolean deleteUser(String username);

    boolean updateUser(User user);
}
