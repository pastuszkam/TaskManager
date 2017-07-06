package com.lyczkul.security.service.impl;

import com.lyczkul.security.model.User;
import com.lyczkul.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by Tomek on 2017-06-21.
 */
@Service
public class UserDataService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Principal principal){
        return userRepository.findByUsername(principal.getName());
    }
}
