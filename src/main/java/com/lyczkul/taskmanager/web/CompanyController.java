package com.lyczkul.taskmanager.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.service.impl.UserDataService;
import com.lyczkul.taskmanager.model.Company;
import com.lyczkul.taskmanager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomek on 2017-06-20.
 */
@RequestMapping(value = "/api/company")
@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserDataService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Company> allCompanies(){
        return companyRepository.findAll();
    }

    @RequestMapping(value = "/{company_id}", method = RequestMethod.GET)
    public Company company(@PathVariable(value = "company_id") Long companyId){
        return companyRepository.findOne(companyId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Company create(@RequestBody Company company, Principal principal){
        User user = userService.getUser(principal);
        Set<User> users = new HashSet<>();
        users.add(user);
        company.setUsers(users);
        companyRepository.save(company);
        return company;
    }

    @RequestMapping(value = "/delete/{company_id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable(value = "company_id") Long companyId){
        companyRepository.delete(companyId);
        return 200;
    }
}
