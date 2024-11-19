package com.example.mvc_pattern_practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mvc_pattern_practice.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
	List<Dept> findByDname(String dname);
}
