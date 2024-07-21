package com.api.employeedepartment_onetomany.services;

import com.api.employeedepartment_onetomany.Repository.DepartmentRepository;
import com.api.employeedepartment_onetomany.model.DepartmentModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentModel addDepartment(DepartmentModel departmentModel) {
        return departmentRepository.save(departmentModel);
    }

    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentModel> getDepartmentById(UUID id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartmentById(UUID id) {
        departmentRepository.deleteById(id);
    }
}
