package com.dinesh.heroku.Dao;

import com.dinesh.heroku.Model.User;

import java.util.List;

public interface UserDao {

    void save_user(User user);

    List<User> getusers();

}
