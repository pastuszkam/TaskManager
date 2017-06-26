package com.lyczkul.taskmanager.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.repository.UserRepository;
import com.lyczkul.security.service.impl.UserDataService;
import com.lyczkul.taskmanager.model.Project;
import com.lyczkul.taskmanager.repository.CompanyRepository;
import com.lyczkul.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Tomek on 2017-06-12.
 */
@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> projects() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<Project> userProjects(@PathVariable(value = "user_id") Long userId) {
        return projectRepository.findAllByUsers(userRepository.findOne(userId));
    }

    @RequestMapping(value = "/company/{company_id}", method = RequestMethod.GET)
    public List<Project> companyProjects(@PathVariable(value = "company_id") Long companyId) {
        return projectRepository.findAllByCompany(companyRepository.findOne(companyId));
    }

    @RequestMapping(value = "/{project_id}", method = RequestMethod.GET)
    public Project project(@PathVariable(value = "project_id") Long projectId) {
        return projectRepository.findOne(projectId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Project create(@RequestBody Project project, Principal principal) {
        projectRepository.save(project);
        return project;
    }

    @RequestMapping(value = "/delete/{project_id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable(value = "project_id") Long projectId) {
        projectRepository.delete(projectId);
        return 200;
    }
}
