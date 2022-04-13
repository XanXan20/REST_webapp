package com.krasilnikov.spring.rest;

import com.krasilnikov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private Communicator communicator;

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = communicator.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        
        return "all-emps-view";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = communicator.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        communicator.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        communicator.deleteEmployee(id);

        return "redirect:/";
    }
}
