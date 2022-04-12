package com.krasilnikovegor.rest.controller;


import com.krasilnikovegor.rest.entity.Employee;
import com.krasilnikovegor.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        System.out.println("Employee with ID = " + id + " was added");
    }
}
