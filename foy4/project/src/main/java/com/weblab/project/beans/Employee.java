package com.weblab.project.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8_bin COLLATE utf8_bin")
    private String empName;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8_bin COLLATE utf8_bin")
    private String empPhoneNumber;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8_bin COLLATE utf8_bin")
    private String empMail;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8_bin COLLATE utf8_bin")
    private String empAddr;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhoneNumber() {
        return empPhoneNumber;
    }

    public void setEmpPhoneNumber(String empPhoneNumber) {
        this.empPhoneNumber = empPhoneNumber;
    }

    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }
}
