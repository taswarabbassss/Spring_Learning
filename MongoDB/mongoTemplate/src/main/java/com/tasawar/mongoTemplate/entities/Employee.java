package com.tasawar.mongoTemplate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private float salary;
    private Address address;
    private Date joiningDate;
}
