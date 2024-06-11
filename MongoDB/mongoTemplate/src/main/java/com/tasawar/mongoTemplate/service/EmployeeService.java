package com.tasawar.mongoTemplate.service;

import com.tasawar.mongoTemplate.entities.Employee;
import com.tasawar.mongoTemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee) {

        employee.setJoiningDate(new Date());
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
    return  repository.getAllEmployees();
    }

    public Employee updateEmployee(Employee employee) {
    return repository.updateEmployee(employee);
    }

    public long deleteEmployee(Employee employee) {
        return repository.deleteEmployee(employee);
    }

    public List<Employee> getEmployeeBySalary(int salary) {
        return repository.getEmployeeBySalary(salary);
    }
}
