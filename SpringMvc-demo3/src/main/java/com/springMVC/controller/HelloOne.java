package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

@Controller
public class HelloOne {
    @RequestMapping("/")
    public String index(ServletRequest request){
        request.setAttribute("hello", "hello,Servlet API!");
        return "index";
    }
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //处理模型数据，即向request域中共享数据
        modelAndView.addObject("testModelAndView","testModelAndView");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("testModel")
    public String testModel(Model model){
        model.addAttribute("testModel", "testModel");
        System.out.println(model.getClass().getName());
        return "index";
    }
    //从主页跳转到test_view页面
    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}

