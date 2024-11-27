package com.example.mvc_pattern_practice.controller;

import com.example.mvc_pattern_practice.model.Dept;
import com.example.mvc_pattern_practice.model.DeptTransfer;
import com.example.mvc_pattern_practice.model.Emp;
import com.example.mvc_pattern_practice.service.DeptService;
import com.example.mvc_pattern_practice.service.EmpService;
import com.example.mvc_pattern_practice.service.DeptTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeptTransferController {

    @Autowired
    private DeptService deptService;
    
    @Autowired
    private EmpService empService;

    @Autowired
    private DeptTransferService deptTransferService;

    // 부서 이동 폼
    @GetMapping("/dept-transfer")
    public String showDeptTransferForm(Model model) {
        List<Emp> employees = empService.getAllEmps();
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("employees", employees);
        model.addAttribute("depts", depts);
        model.addAttribute("deptTransfer", new DeptTransfer()); // 부서 이동 객체 초기화
        return "dept-transfer";
    }

    // 부서 이동 처리
    @PostMapping("/dept-transfer")
    public String transferEmployee(DeptTransfer deptTransfer) {
        // 부서 이동 처리 로직
        deptTransferService.transferEmployee(deptTransfer.getEmployee().getEmpno(), deptTransfer.getDepartment().getDeptno());
        return "redirect:/depts"; // 부서 목록 페이지로 리디렉션
    }
}
