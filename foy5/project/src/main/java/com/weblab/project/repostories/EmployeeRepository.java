package com.weblab.project.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weblab.project.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
