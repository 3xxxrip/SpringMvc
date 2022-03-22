package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

@Controller
public class TestCtroller {
    //返回到视图解析器跳转页面
    @RequestMapping(value = "/")
    //RequestMapping的value声明为String[]，说明可以存储多个请求地址，表示该方法可以处理多个请求地址
    public String index(){
        return "index";
    }

//    //只接受get请求方法
//    @GetMapping(value = "/target")
//    public String target1(){
//        return "target";
//    }

//    //测试RequesParams
//    @PostMapping(value = "/target",params = {"!username","password=123456"})
//    public String target2(){
//        return "target";
//    }

    //原生servletAPI获取请求参数
//    @PostMapping(value = "/target")
//    public String target2(ServletRequest request){
//        String password = request.getParameter("password");
//        System.out.println("密码是"+password);
//        return "target";
//    }

    //路径占位符
    @GetMapping(value = "/target/{password}")
    public String target2(@PathVariable("password") String password){
        System.out.println("密码是" + password);
        return "target";
    }

}
