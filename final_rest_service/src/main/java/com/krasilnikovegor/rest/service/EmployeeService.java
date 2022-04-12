package com.krasilnikovegor.rest.service;

import com.krasilnikovegor.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);

    public Employee getEmployee(int id);
}
