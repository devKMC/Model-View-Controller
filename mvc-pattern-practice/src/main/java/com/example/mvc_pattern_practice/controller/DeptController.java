package com.example.mvc_pattern_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc_pattern_practice.model.Dept;
import com.example.mvc_pattern_practice.service.DeptService;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 부서 목록 조회
    @GetMapping("/depts")
    public String getDepts(Model model) {
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts", depts);
        return "dept-list"; // 부서 목록 페이지
    }

    // 부서 생성 폼 페이지
    @GetMapping("/depts/new")
    public String showCreateForm(Model model) {
        model.addAttribute("dept", new Dept());
        return "dept-create"; // 부서 추가 폼 페이지
    }

    // 부서 생성(추가)
    @PostMapping("/depts")
    public String createDept(Dept dept) {
        deptService.saveDept(dept);
        return "redirect:/depts"; // 부서 목록 페이지로 리다이렉트
    }

    // 부서 삭제
    @PostMapping("/depts/delete/{id}")
    public String deleteDept(@PathVariable("id") Integer id) {
        deptService.deleteDept(id);
        return "redirect:/depts"; // 부서 목록 페이지로 리다이렉트
    }

    // 부서 수정 폼 페이지
    @GetMapping("/depts/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Dept dept = deptService.getDeptById(id);
        model.addAttribute("dept", dept);
        return "dept-edit"; // 부서 수정 폼 페이지
    }

    // 부서 수정 처리
    @PostMapping("/depts/edit/{id}")
    public String updateDept(@PathVariable("id") Integer id, Dept dept) {
        deptService.updateDept(id, dept);
        return "redirect:/depts"; // 부서 목록 페이지로 리다이렉트
    }
}
