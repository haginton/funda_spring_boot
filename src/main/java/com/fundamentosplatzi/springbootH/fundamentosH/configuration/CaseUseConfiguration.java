package com.fundamentosplatzi.springbootH.fundamentosH.configuration;

import com.fundamentosplatzi.springbootH.fundamentosH.caseuse.GetUser;
import com.fundamentosplatzi.springbootH.fundamentosH.caseuse.GetUserImpl;
import com.fundamentosplatzi.springbootH.fundamentosH.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    public GetUser getUser(UserService userService){
        return new GetUserImpl(userService);
    }
}
