package com.api.employeedepartment_onetomany.controllers;

import com.api.employeedepartment_onetomany.Repository.DepartmentRepository;
import com.api.employeedepartment_onetomany.dtos.DepartmentDto;
import com.api.employeedepartment_onetomany.model.DepartmentModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public ResponseEntity<Object> addDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        DepartmentModel departmentModel = new DepartmentModel();
        BeanUtils.copyProperties(departmentDto, departmentModel);
        DepartmentModel departmentModelSave = departmentRepository.save(departmentModel);
        return ResponseEntity.status(HttpStatus.OK).body(departmentModelSave);
    }

    @GetMapping
    public ResponseEntity<Object> getAllDepartments() {
        List<DepartmentModel> departmentModelList = departmentRepository.findAll();
        return ResponseEntity.ok(departmentModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable UUID id) {
        Optional<DepartmentModel> departmentModelOptional = departmentRepository.findById(id);
        if (departmentModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(departmentModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartmentById(@PathVariable UUID id) {
        Optional<DepartmentModel> departmentModelOptional = departmentRepository.findById(id);
        if (departmentModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
        departmentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Department deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDepartmentById(@PathVariable UUID id, @RequestBody @Valid DepartmentDto departmentDto) {
        Optional<DepartmentModel> departmentModelOptional = departmentRepository.findById(id);
        if (departmentModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
        BeanUtils.copyProperties(departmentDto, departmentModelOptional.get(), "id");
        DepartmentModel departmentModel = departmentRepository.save(departmentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(departmentModel);
    }
}

