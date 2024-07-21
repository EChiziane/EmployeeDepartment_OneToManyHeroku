package com.api.employeedepartment_onetomany.Repository;

import com.api.employeedepartment_onetomany.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
}
