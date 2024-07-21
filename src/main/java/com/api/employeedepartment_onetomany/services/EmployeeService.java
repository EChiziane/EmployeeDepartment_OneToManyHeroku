package com.api.employeedepartment_onetomany.services;

import com.api.employeedepartment_onetomany.Repository.EmployeeRepository;
import com.api.employeedepartment_onetomany.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> getEmployee(UUID id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
