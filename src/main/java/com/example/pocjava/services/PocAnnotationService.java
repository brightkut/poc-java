package com.example.pocjava.services;

import com.example.pocjava.model.User;
import com.example.pocjava.model.User2;
import com.example.pocjava.model.UserDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PocAnnotationService {
    @Autowired
    private ObjectMapper objectMapper;

    public User getUserWithJsonIgnore(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        return user;
    }

    public UserDetail getUserDetailWithJsonIgnorePropertiesMultipleField(){
        UserDetail userDetail = new UserDetail();
        userDetail.setName("name");
        userDetail.setSurname("surname");
        userDetail.setEmail("test@g.com");

        return userDetail;
    }
}
