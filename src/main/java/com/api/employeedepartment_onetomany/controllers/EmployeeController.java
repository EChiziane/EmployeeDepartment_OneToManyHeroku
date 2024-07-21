package com.api.employeedepartment_onetomany.controllers;

import com.api.employeedepartment_onetomany.dtos.EmployeeDto;
import com.api.employeedepartment_onetomany.model.EmployeeModel;
import com.api.employeedepartment_onetomany.services.DepartmentService;
import com.api.employeedepartment_onetomany.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Object> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel();
        var department = departmentService.getDepartmentById(employeeDto.getDepartment());
        if (department.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setDepartment(department.get());
        var savedEmployee = employeeService.addEmployee(employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable UUID id) {
        Optional<EmployeeModel> EmployeeModel = employeeService.getEmployee(id);
        if (EmployeeModel.isPresent()) {
            return ResponseEntity.ok(EmployeeModel.get());
        }
        return ResponseEntity.notFound().build();
    }


}
