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

    public List<Emp> getAllEmps() {
        return empRepository.findAll();
    }
}
