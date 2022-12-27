package com.fundamentosplatzi.springbootH.fundamentosH.caseuse;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import com.fundamentosplatzi.springbootH.fundamentosH.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
