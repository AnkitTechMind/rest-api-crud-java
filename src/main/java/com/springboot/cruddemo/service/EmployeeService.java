package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
