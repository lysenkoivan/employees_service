package com.griddynamics.workshops.openshift.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.griddynamics.workshops.openshift.example.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
