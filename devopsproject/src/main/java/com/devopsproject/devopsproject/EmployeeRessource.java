package com.devopsproject.devopsproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devopsproject.devopsproject.model.Employee;
import com.devopsproject.devopsproject.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeRessource {
    private final EmployeeService employeeService;

    public EmployeeRessource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/all")
    public ResponseEntity <List <Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.finAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeByID(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity <Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity <Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatEmployee = employeeService.updatEmployee(employee);
        return new ResponseEntity<>(updatEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity <?> deletEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
