package com.example.numpySpring.controller;

import com.example.numpySpring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.numpySpring.repository.EmployeeDAO;
import com.example.numpySpring.model.Employees;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;


    @GetMapping(path = "/",
            produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }


    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee) {

        Integer id = employeeDao
                .getAllEmployees()
                .getEmployeeList()
                .size()
                + 1;
        employee.setId(id);
        employeeDao.addEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}
 

