package com.springMvc.controller;

import com.springMvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "success";
    }

    //在导入过jackson依赖之后，在springmvc中开启mvc注解驱动，然后用@ResponseBody注解一个方法时就会把返回值作为json字符串传给前端
    @RequestMapping("testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User("longjian",20,"男");
    }
}
