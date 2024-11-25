package com.example.mvc_pattern_practice.service;

import com.example.mvc_pattern_practice.model.Dept;
import com.example.mvc_pattern_practice.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    // 모든 부서 조회
    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }

    // 부서 ID로 조회
    public Dept getDeptById(Integer id) {
        Optional<Dept> dept = deptRepository.findById(id);
        return dept.orElse(null); // 부서가 없으면 null 반환
    }

    // 부서 저장 (새 부서 추가)
    public void saveDept(Dept dept) {
        deptRepository.save(dept);
    }

    // 부서 삭제
    public void deleteDept(Integer id) {
        deptRepository.deleteById(id);
    }

    // 부서 수정
    public void updateDept(Integer id, Dept dept) {
        // 먼저 기존 부서를 찾아 업데이트
        if (deptRepository.existsById(id)) {
            dept.setDeptno(id); // 수정할 부서의 ID를 설정
            deptRepository.save(dept);
        }
    }
}
