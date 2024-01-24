package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
