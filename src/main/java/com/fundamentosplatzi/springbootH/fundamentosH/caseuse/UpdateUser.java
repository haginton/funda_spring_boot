package com.fundamentosplatzi.springbootH.fundamentosH.caseuse;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import com.fundamentosplatzi.springbootH.fundamentosH.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
