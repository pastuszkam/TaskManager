package com.lyczkul.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomek on 04.06.2017.
 */
@RestController
public class DefaultController {
    @RequestMapping(value = "/")
    public String index(){
        return "New World Order";
    }
}
