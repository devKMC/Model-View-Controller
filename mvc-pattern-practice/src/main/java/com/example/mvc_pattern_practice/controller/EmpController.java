package com.example.mvc_pattern_practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc_pattern_practice.model.Emp;
import com.example.mvc_pattern_practice.service.EmpService;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    // 직원 목록 조회
    @GetMapping("/emps")
    public String getEmps(Model model) {
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps", emps);
        return "emp-list";
    }

    // 직원 생성 폼 페이지
    @GetMapping("/emps/new")
    public String showCreateForm(Model model){
        model.addAttribute("emp", new Emp());
        return "emp-create";
    }

    // 직원 생성(입사)
    @PostMapping("/emps")
    public String createEmp(Emp emp){
        empService.createEmp(emp);
        return "redirect:/emps";
    }

    // 직원 삭제(퇴사)
    @DeleteMapping("/emps/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        empService.deleteEmp(id);
        return "redirect:/emps";
    }

    // 직원 수정 폼 페이지
    @GetMapping("/emps/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Emp emp = empService.getEmpById(id);
        model.addAttribute("emp", emp);
        return "emp-edit"; // emp-edit.html 생성 필요
    }

    // 직원 수정 처리
    @PostMapping("/emps/edit/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Emp emp) {
        empService.updateEmp(id, emp);
        return "redirect:/emps";
    }
}

