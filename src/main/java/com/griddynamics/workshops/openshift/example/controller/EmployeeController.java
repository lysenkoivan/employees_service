package com.griddynamics.workshops.openshift.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.griddynamics.workshops.openshift.example.dto.EmployeeDTO;
import com.griddynamics.workshops.openshift.example.model.Employee;
import com.griddynamics.workshops.openshift.example.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    private Employee convertFromDto(EmployeeDTO employeeDTO) {
        Employee recurrentBudget = modelMapper.map(employeeDTO, Employee.class);
        return recurrentBudget;
    }

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() { return employeeService.getAllEmployees(); }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = convertFromDto(employeeDTO);
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) { employeeService.deleteEmployee(id); }
}
