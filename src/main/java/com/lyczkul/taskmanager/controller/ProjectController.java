package com.lyczkul.taskmanager.controller;

import com.lyczkul.security.repository.UserRepository;
import com.lyczkul.taskmanager.model.Project;
import com.lyczkul.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomek on 2017-06-12.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> projects(){
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/projects/user/{user_id}" , method = RequestMethod.GET)
    public List<Project> userProjects(@PathVariable(value = "user_id") Long userId){
        return projectRepository.findAllByUsers(userRepository.findOne(userId));
    }


}
