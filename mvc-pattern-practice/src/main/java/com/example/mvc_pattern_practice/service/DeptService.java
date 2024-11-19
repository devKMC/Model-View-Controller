package com.example.mvc_pattern_practice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc_pattern_practice.model.Dept;
import com.example.mvc_pattern_practice.repository.DeptRepository;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }
}
