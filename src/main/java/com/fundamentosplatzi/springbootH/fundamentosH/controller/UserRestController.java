package com.fundamentosplatzi.springbootH.fundamentosH.controller;

import com.fundamentosplatzi.springbootH.fundamentosH.caseuse.GetUser;
import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //Create, Get, Delete, Update

    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    public List<User> get(){
        return getUser.getAll();
    }
}
