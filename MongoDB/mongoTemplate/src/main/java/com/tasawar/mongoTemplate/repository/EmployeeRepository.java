package com.tasawar.mongoTemplate.repository;

import com.tasawar.mongoTemplate.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public Employee save(Employee employee) {
        return mongoTemplate.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return mongoTemplate.findAll(Employee.class);
    }

    public Employee updateEmployee(Employee employee) {
        return mongoTemplate.save(employee);
    }

    public long deleteEmployee(Employee employee) {
        long deletedCount = mongoTemplate.remove(employee).getDeletedCount();
        return deletedCount;
    }

    public List<Employee> getEmployeeBySalary(int salary) {
        Query query = new Query();
        query.addCriteria(Criteria.where("salary").gte(salary));
//        query.fields().exclude("address","joiningDate");
        return mongoTemplate.find(query, Employee.class);
    }
}
