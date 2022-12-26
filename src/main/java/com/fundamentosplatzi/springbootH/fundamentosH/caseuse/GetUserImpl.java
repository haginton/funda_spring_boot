package com.fundamentosplatzi.springbootH.fundamentosH.caseuse;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import com.fundamentosplatzi.springbootH.fundamentosH.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser{

    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
