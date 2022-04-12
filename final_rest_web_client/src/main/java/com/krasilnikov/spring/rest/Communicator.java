package com.krasilnikov.spring.rest;

import com.krasilnikov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communicator {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/final_rest_service/api/employees";

    public List<Employee> getAllEmployees(){

        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {});

        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public void saveEmployee(Employee employee){

        int id = employee.getId();

        if(id == 0){

            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
        }
        else{
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID = " + id + " was added");
        }

    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/" + id);
    }

    public Employee getEmployee(int id){

        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);

        return employee;
    }
}
