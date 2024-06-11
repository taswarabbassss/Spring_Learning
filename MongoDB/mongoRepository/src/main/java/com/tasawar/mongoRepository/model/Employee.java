package com.tasawar.mongoRepository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private String id;

    public Employee(String firstName, String lastName, Address address,Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
    }

    private String firstName;
    private String lastName;
    private Double salary;
    private Address address;
}

