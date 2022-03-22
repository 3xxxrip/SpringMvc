package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value ={"/hello"},method = {RequestMethod.GET,RequestMethod.POST})
//写在类上的总用就相当于书城项目中的管理模块和用户模块
public class RequestMappingController {
    //返回到视图解析器跳转页面
    //method就是请求的方法过滤
    @RequestMapping(value = "/**/success")
    //此时解析请求的路径就变为了/hello/success
    public String success(){
        return "success";
    }
}
