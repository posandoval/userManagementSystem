package com.posandoval.UserManagementSystem.service;

import com.posandoval.UserManagementSystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    User create(User user);
    User findById(Integer id);
    void deledeById(Integer id);
    User updateUser(User user);
}
