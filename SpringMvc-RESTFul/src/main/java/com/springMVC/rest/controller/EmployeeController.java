package com.springMVC.rest.controller;

import com.springMVC.rest.bean.Employee;
import com.springMVC.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    @Qualifier("employeeDao")
    private EmployeeDao employeeDao;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getEmployee(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employees", all);
        return "employeeList";
    }
    //删除员工信息
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deteleEmployee(@PathVariable("id") Integer id,Model model){
        //删除指定员工信息
        employeeDao.delete(id);
        Collection<Employee> all = employeeDao.getAll();
        //删除之后的所有员工信息保存到request域中
        model.addAttribute("employees", all);
        return "redirect:/employee";
    }

    //添加员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
       //直接保存
            employeeDao.save(employee);
            //重定向到用户信息页面
      return "redirect:/employee";
    }

    //在修改员工信息的时候回显数据用的
    @RequestMapping(value = "/employee_update/{id}",method = RequestMethod.GET)
    public String updateEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "/employee_update";
    }
    //修改员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //保存修改后的用户信息
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/employee";
    }
}
