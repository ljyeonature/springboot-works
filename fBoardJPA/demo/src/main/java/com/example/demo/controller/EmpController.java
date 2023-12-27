package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import java.util.*;
// import com.example.demo.service.EmployeeService;


@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/{step}")
    public String viewPage(@PathVariable String step){
        return "/emp/"+ step;
    }

    @RequestMapping("/getEmployeeList")
    public void getEmployeeList(Model m) {
        List<Object[]> list = employeeService.getEmployeeList();
        m.addAttribute("emp", list);

    }
    
    
}
