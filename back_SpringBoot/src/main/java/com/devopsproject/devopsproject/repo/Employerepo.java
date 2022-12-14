package com.devopsproject.devopsproject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devopsproject.devopsproject.model.Employee;

public interface Employerepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);    
}
