package com.example.mvc_pattern_practice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc_pattern_practice.model.Emp;
import com.example.mvc_pattern_practice.repository.EmpRepository;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    // 직원 목록 조회
    public List<Emp> getAllEmps() {
        return empRepository.findAll();
    }

    // 직원 생성
    public void createEmp(Emp emp){
        empRepository.save(emp);
    }

    // 직원 삭제
    public void deleteEmp(Integer id){
        empRepository.deleteById(id);
    }

    // 직원 조회
    public Emp getEmpById(Integer id) {
        return empRepository.findById(id).orElse(null);
    }

    // 직원 수정
    public void updateEmp(Integer id, Emp emp) {
        emp.setEmpno(id); // ID를 설정하여 기존 직원 정보 업데이트
        empRepository.save(emp);
    }
}
