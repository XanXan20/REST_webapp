package com.krasilnikov.spring.rest.entity;

public class EmployeeWithNewPassword {

    private Employee employee;

    private String newPassword;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public EmployeeWithNewPassword() {
    }

    public EmployeeWithNewPassword(Employee employee, String newPassword) {
        this.employee = employee;
        this.newPassword = newPassword;
    }
}
