package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    public Employee findById(int id){
        return employeeDAO.findById(id);
    }

    @Transactional
    public Employee save(Employee employee){
        return employeeDAO.save(employee);
    }

    @Transactional
    public void deleteById(int id){
         employeeDAO.deleteById(id);
    }
}
