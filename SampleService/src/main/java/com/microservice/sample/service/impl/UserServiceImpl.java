package com.microservice.sample.service.impl;

import com.microservice.sample.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean validateUser(String userId) {

        //ANAND : TODO : Fetch the data from userService and validate

        return true;
    }
}
