package com.example.mvc_pattern_practice.service;

import com.example.mvc_pattern_practice.model.Emp;
import com.example.mvc_pattern_practice.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptTransferService {

    @Autowired
    private EmpRepository empRepository; // EmpRepository 호출

    // 직원의 부서 이동 처리
    public void transferEmployee(Integer empId, Integer newDeptId) {
        // 직원 정보 가져오기
        Emp employee = empRepository.findById(empId).orElse(null);

        if (employee != null) {
            // 직원의 부서 정보 업데이트
            employee.setDeptno(newDeptId);
            empRepository.save(employee); // 부서 이동 정보 저장
        }
    }
}
