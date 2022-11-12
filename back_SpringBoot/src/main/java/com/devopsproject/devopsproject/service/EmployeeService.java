package com.devopsproject.devopsproject.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devopsproject.devopsproject.Exception.UserNotFoundException;
import com.devopsproject.devopsproject.model.Employee;
import com.devopsproject.devopsproject.repo.Employerepo;

@Service
public class EmployeeService {
    private final Employerepo employerepo;

    @Autowired
    public EmployeeService(Employerepo employerepo) {
        this.employerepo = employerepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeecode(UUID.randomUUID().toString());
        return employerepo.save(employee);
    }

    public List<Employee> finAllEmployees() {
        return employerepo.findAll();
    }

    public Employee updatEmployee(Employee employee) {
        return employerepo.save(employee);
    }

    public Employee findEmployeeByID(Long id) {
        return employerepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id+ " was not found"));
    }

    public void deleteEmployee(Long id) {
        employerepo.deleteEmployeeById(id);
    }

}
