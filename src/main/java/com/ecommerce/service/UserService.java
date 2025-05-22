package com.ecommerce.service;

import com.ecommerce.entity.User;

public interface UserService {

    boolean userExists(String email);

    void registerUser(User user);

    User findByEmail(String email);

    User findById(Long id);




}
