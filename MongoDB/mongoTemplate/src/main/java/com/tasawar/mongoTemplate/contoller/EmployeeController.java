package com.tasawar.mongoTemplate.contoller;

import com.tasawar.mongoTemplate.entities.Employee;
import com.tasawar.mongoTemplate.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    public final EmployeeService service;


    @GetMapping
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }
    @GetMapping("/salary")
    public List<Employee> getEmployeeBySalary(@RequestParam(value = "salary")  int salary){
        return service.getEmployeeBySalary(salary);
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return service.save(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping
    public long deleteEmployee(@RequestBody Employee employee){
        return service.deleteEmployee(employee);
    }

}
