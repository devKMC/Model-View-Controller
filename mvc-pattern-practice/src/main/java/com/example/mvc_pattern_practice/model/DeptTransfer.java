package com.example.mvc_pattern_practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class DeptTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 부서 이동 ID
    private LocalDateTime transferDate; // 부서 이동일

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    private Emp employee; // 이동한 직원

    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    private Dept department; // 이동한 부서

    // Getter, Setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public Emp getEmployee() {
        return employee;
    }

    public void setEmployee(Emp employee) {
        this.employee = employee;
    }

    public Dept getDepartment() {
        return department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }
}
