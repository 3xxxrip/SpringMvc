package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RESTful {
    @RequestMapping(value = "/success",method = RequestMethod.PUT)
    public String restFulPut(String username){
        System.out.println("修改用户" + username);
        return "success";
    }
}
