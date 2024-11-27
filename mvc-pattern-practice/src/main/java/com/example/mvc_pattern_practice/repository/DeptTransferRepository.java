package com.example.mvc_pattern_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc_pattern_practice.model.DeptTransfer;

public interface DeptTransferRepository extends JpaRepository<DeptTransfer, Integer> {
}