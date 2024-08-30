package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestControlller {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestControlller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> fillAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) throws RuntimeException{
        try {
            Employee employee = employeeService.findById(employeeId);
            return employee;
        }catch (Exception e) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updayeEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);
        employeeService.deleteById(employeeId);
    }
}
