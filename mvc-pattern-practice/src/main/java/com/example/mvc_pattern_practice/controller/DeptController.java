package com.example.mvc_pattern_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mvc_pattern_practice.model.Dept;
import com.example.mvc_pattern_practice.service.DeptService;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public String getDepts(Model model) {
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts", depts);
        return "dept-list";
    }
}
