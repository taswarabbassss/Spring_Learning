package com.tasawar.mongoRepository;

import com.tasawar.mongoRepository.model.Address;
import com.tasawar.mongoRepository.model.Employee;
import com.tasawar.mongoRepository.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MongoRepositoryApplication implements CommandLineRunner {
    public enum FieldName {
        NAME,
        DATE_MODIFIED
    }

    public enum SortDirection {
        ASC,
        DESC
    }
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoRepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Employee> listOfEmployees = new ArrayList<Employee>();
//        Employee e1 = new Employee("BAT", "MAN", new Address("Bat Cave", "My Back Yard", "Gotham", "CA", 1234), 5000.0);
//        Employee e2 = new Employee("SUPER", "MAN", new Address("Kriptonian Home", "Kriptonian City", "Kripton", "IN SPACE", 2000), 10000.0);
//        Employee e3 = new Employee("AQUA", "MAN", new Address("My House", "In Ocean", "Atlantis", "NOWHERE", 77777), 1000.0);
//        Employee e4 = new Employee("IRON", "MAN", new Address("Malibu", "Near Ocean", "CA", "CA", 1234), 12000.0);
//        Employee e5 = new Employee("Oliver", "Queen", new Address("On Street", "at night", "starcity", "US", 1232), 8000.0);
//        Employee e6 = new Employee("Berry", "Allan", new Address("Polics Station", "Star LAB", "Central City", "AAA", 333444), 6000.0);
//        Employee e7 = new Employee("Bruce", "Banner", new Address("In Lab", "Near Militery Base", "New York", "NY", 1234), 7000.0);
//        Employee e8 = new Employee("Steve", "Rogers", new Address("On Street", "at night", "starcity", "US", 1232), 8000.0);
//        Employee e9 =  new Employee("Thor", "Esgardian", new Address ("Polics Station","Star LAB", "Central City", "AAA", 333444), 6000.0);
//        Employee e10 = new Employee("Peter", " Parker", new Address("School", "School 2", "Forest Hills,", "New York", 23456), 4000.0);
//        Employee e11 = new Employee("Natasha", "Romanoff", new Address("Street 1", "at night", "Stalingrad", "Russia", 22222), 8000.0);
//        Employee e12 = new Employee("Phil", "Colson", new Address("Unknown", "Shield", "Boston", "MA", 111122345), 6000.0);
//        listOfEmployees.add(e1);
//        listOfEmployees.add(e2);
//        listOfEmployees.add(e3);
//        listOfEmployees.add(e4);
//        listOfEmployees.add(e5);
//        listOfEmployees.add(e6);
//        listOfEmployees.add(e7);
//        listOfEmployees.add(e8);
//        listOfEmployees.add(e9);
//        listOfEmployees.add(e10);
//        listOfEmployees.add(e11);
//        listOfEmployees.add(e12);
//        System.out.println(List.of(SortDirection.ASC,SortDirection.DESC).contains(SortDirection.valueOf("ASC")));
//        System.out.println(List.of(FieldName.NAME,FieldName.DATE_MODIFIED).contains(FieldName.valueOf("ASC")));

//        System.out.println(isSortRequire(null,"asc"));

//        employeeRepository.insert(listOfEmployees);
        System.out.println("App is running successfully...");
    }

    private boolean isSortRequire(String fieldName, String sortDirection) {
        boolean validFields = false;
        boolean isNotNull = fieldName != null && sortDirection != null;
        try {
            validFields = List.of(FieldName.NAME,FieldName.DATE_MODIFIED).contains(FieldName.valueOf(fieldName))
                    && List.of(SortDirection.ASC,SortDirection.DESC).contains(SortDirection.valueOf(sortDirection));
        }catch (Exception e){
        }

        return validFields;
    }
}
