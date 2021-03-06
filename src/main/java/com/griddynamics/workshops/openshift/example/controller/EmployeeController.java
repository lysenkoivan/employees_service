package com.griddynamics.workshops.openshift.example.controller;

import com.griddynamics.workshops.openshift.example.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.griddynamics.workshops.openshift.example.dto.EmployeeDTO;
import com.griddynamics.workshops.openshift.example.model.Employee;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee convertFromDto(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    @RequestMapping("/employee")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/employee")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = convertFromDto(employeeDTO);
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id) { employeeService.deleteEmployee(id); }
}
