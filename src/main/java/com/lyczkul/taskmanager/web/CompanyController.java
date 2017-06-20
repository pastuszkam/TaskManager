package com.lyczkul.taskmanager.web;

import com.lyczkul.taskmanager.model.Company;
import com.lyczkul.taskmanager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tomek on 2017-06-20.
 */
@RequestMapping(value = "/api")
@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/all_companies", method = RequestMethod.GET)
    public List<Company> allCompanies(){
        return companyRepository.findAll();
    }
}
