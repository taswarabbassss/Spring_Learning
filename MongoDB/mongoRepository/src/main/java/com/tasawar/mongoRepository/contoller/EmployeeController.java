package com.tasawar.mongoRepository.contoller;

import com.tasawar.mongoRepository.model.Employee;
import com.tasawar.mongoRepository.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return  service.getAllEmployees();
    }

    @PostMapping
    public Employee insertEmployee(@RequestBody Employee employee){

        return service.insertEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){

        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleted(@PathVariable("id") String id){
        String responce =  service.deleteEmployee(id);
        return ResponseEntity.ok(responce);
    }

    @GetMapping("/page")
    public Map<String, Object> getAllEmployeesInPage(@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
                                     @RequestParam(name = "pageSize",defaultValue = "2") int pageSize,
                                     @RequestParam(name = "sortBy",defaultValue = "id") String sortBy){
        return  service.getAllEmployeesInPage(pageNo,pageSize,sortBy);
    }

    @PostMapping("/example")
    public List<Employee> getAllByExample(@RequestBody Employee employee){
        return  service.getAllEmployeesByExampleExecutor(employee);
    }

    @GetMapping("/firstName")
    public List<Employee> getEmployeesByFirstName(@RequestParam("firstName") String firstName){

        return  service.getEmployeesByFirstName(firstName);
    }

    @GetMapping("/startingWith")
    public List<Employee> getEmployeesStartingWith(@RequestParam("firstName") String firstName){

        return  service.getEmployeesStartingWith(firstName);
    }

    @GetMapping("/zipcode")
    public List<Employee> getEmployeeByZipCode(@RequestParam("zipCode") int zipCode){

        return  service.getEmployeeByZipCode(zipCode);
    }

    @GetMapping("/salary")
    public List<Employee> getEmployeeByZipCode(@RequestParam("salary") float salary){

        return  service.getEmployeeBySalaryGreaterThan(salary);
    }
}
