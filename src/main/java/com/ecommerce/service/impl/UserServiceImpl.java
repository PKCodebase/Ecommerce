package com.ecommerce.service.impl;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean userExists(String email) {
        return false;
    }

    @Override
    public void registerUser(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
