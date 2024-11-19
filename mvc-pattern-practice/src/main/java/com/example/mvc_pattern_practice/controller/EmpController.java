package com.example.mvc_pattern_practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mvc_pattern_practice.model.Emp;
import com.example.mvc_pattern_practice.service.EmpService;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public String getEmps(Model model) {
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps", emps);
        return "emp-list";
    }
}
