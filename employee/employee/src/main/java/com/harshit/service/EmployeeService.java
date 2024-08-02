package com.harshit.service;

import com.harshit.entity.EmployeeEntity;
import com.harshit.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeEntity postEmployee(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getEmployee(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeId(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeEntity update(Long id, EmployeeEntity employeeEntity){
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if(optionalEmployeeEntity.isPresent()){
            EmployeeEntity existingEmployee = optionalEmployeeEntity.get();

            existingEmployee.setName(employeeEntity.getName());
            existingEmployee.setEmail(employeeEntity.getEmail());
            existingEmployee.setPhone(employeeEntity.getPhone());
            existingEmployee.setDepartment(employeeEntity.getDepartment());

            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public void delete(Long id){
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
