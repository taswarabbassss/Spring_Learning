package com.tasawar.mongoRepository.service;

import com.tasawar.mongoRepository.model.Employee;
import com.tasawar.mongoRepository.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee insertEmployee(Employee employee) {
        return repository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public String deleteEmployee(String id) {
        repository.deleteById(id);
        return "Deleted Successfully";
    }

    public Map<String, Object> getAllEmployeesInPage(int pageNo, int pageSize, String sortBy) {

        Map<String, Object> response = new HashMap<>();
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        Pageable pageAble = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> employeePage = repository.findAll(pageAble);
        response.put("data", employeePage.getContent());
        response.put("Total No of pages", employeePage.getTotalPages());
        response.put("Total No of Elements", employeePage.getTotalElements());
        response.put("Current Page No", employeePage.getNumber());
        return response;
    }

    public List<Employee> getAllEmployeesByExampleExecutor(Employee employee) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("firstName", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.ENDING));
        Example<Employee> empExample = Example.of(employee,matcher);
        return repository.findAll(empExample);
    }

    public List<Employee> getEmployeesByFirstName(String firstName) {
       return repository.findByFirstName(firstName);
    }

    public List<Employee> getEmployeesStartingWith(String firstName) {
        return repository.findByFirstNameStartingWith(firstName);
    }

    public List<Employee> getEmployeeByZipCode(int zipCode) {
        return repository.findByAddressZipCode(zipCode);
    }

    public List<Employee> getEmployeeBySalaryGreaterThan(float salary) {
        return  repository.abc(salary);
    }
}
