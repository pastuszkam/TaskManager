package com.lyczkul.security.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomek on 05.06.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class SecurityController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
}
