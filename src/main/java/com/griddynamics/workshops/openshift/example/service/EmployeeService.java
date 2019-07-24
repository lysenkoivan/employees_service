package com.griddynamics.workshops.openshift.example.service;

import java.util.List;

import com.griddynamics.workshops.openshift.example.model.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee getEmployee(Long id);

    public void addEmployee(Employee capitalProject);

    public void updateEmployee(Long id, Employee capitalProject);

    public void deleteEmployee(Long id);
}
