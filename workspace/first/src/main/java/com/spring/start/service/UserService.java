package com.spring.start.service;


import com.spring.start.model.User;

import java.util.List;

public interface UserService {

    int addUser (User user);
    List<User> findAllUsers();
}
