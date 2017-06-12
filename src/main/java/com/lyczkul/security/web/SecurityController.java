package com.lyczkul.security.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.repository.RoleRepository;
import com.lyczkul.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomek on 05.06.2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName("user"));
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users(){
        return userRepository.findAll();
    }
}
