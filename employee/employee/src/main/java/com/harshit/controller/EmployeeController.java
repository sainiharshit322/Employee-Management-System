package com.harshit.controller;

import com.harshit.entity.EmployeeEntity;
import com.harshit.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/employee")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.postEmployee(employeeEntity);
    }

    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        EmployeeEntity employeeEntity = employeeService.getEmployeeId(id);
        if(employeeEntity == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeEntity);
    }

    @PatchMapping(path = "/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity updatedEmployee = employeeService.update(id, employeeEntity);
        if(updatedEmployee == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(path = "/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        try{
            employeeService.delete(id);
            return new ResponseEntity<>("Employee with id"+ id + " is successfully deleted", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
