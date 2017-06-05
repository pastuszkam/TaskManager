package com.lyczkul.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomek on 04.06.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class DefaultController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "New World Order";
    }
}
