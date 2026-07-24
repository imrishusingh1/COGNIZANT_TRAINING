package com.example.ems;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        
        Department engineering = departmentRepository.save(new Department("Engineering"));
        Department hr = departmentRepository.save(new Department("Human Resources"));
        Department finance = departmentRepository.save(new Department("Finance"));

        Employee e1 = new Employee("Alice Johnson", "alice@example.com", "Senior Developer", 85000.0);
        e1.setDepartment(engineering);
        employeeRepository.save(e1);

        Employee e2 = new Employee("Bob Smith", "bob@example.com", "Junior Developer", 55000.0);
        e2.setDepartment(engineering);
        employeeRepository.save(e2);

        Employee e3 = new Employee("Carol White", "carol@example.com", "HR Manager", 70000.0);
        e3.setDepartment(hr);
        employeeRepository.save(e3);

        Employee e4 = new Employee("David Brown", "david@example.com", "Finance Analyst", 65000.0);
        e4.setDepartment(finance);
        employeeRepository.save(e4);

        System.out.println("=== Employee Management System Started ===");
        System.out.println("Departments: " + departmentRepository.count());
        System.out.println("Employees:   " + employeeRepository.count());
        System.out.println("REST API: http://localhost:8081/api/employees");
        System.out.println("H2 Console: http://localhost:8081/h2-console");
    }
}
