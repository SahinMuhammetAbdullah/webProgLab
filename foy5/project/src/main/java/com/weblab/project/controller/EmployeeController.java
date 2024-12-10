package com.weblab.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.weblab.project.beans.Employee;
import com.weblab.project.repostories.EmployeeRepository;
import com.weblab.project.services.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @PostMapping("/newEmp")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer empId) {
        return employeeRepository.findById(empId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/uptEmp/{empId}")
    Optional<Object> updateEmployee(@RequestBody Employee newEmployee, @PathVariable String empId) {
        try {
            Integer parsedEmpId = Integer.parseInt(empId);
            return employeeRepository.findById(parsedEmpId).map(emp -> {
                emp.setEmpMail(newEmployee.getEmpMail());
                emp.setEmpName(newEmployee.getEmpName());
                emp.setEmpPhoneNumber(newEmployee.getEmpPhoneNumber());
                emp.setEmpAddr(newEmployee.getEmpAddr());
                return employeeRepository.save(emp);
            });
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid empId format");
        }
    }

    @GetMapping("/delEmp/{empId}")
    String deleteEmployee(@PathVariable Integer empId) {

        employeeRepository.deleteById(empId);
        return "redirect:/";
    }
}
