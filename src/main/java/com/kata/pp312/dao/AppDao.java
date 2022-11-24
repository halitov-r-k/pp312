package com.kata.pp312.dao;

import com.kata.pp312.modeles.User;

import java.util.List;

public interface AppDao {
    List<User> getUserList();

    void saveUser(User user);

    User getUser(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
