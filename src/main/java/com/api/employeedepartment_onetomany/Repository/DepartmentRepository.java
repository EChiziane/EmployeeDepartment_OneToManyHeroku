package com.api.employeedepartment_onetomany.Repository;

import com.api.employeedepartment_onetomany.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface DepartmentRepository extends JpaRepository<DepartmentModel, UUID> {
}
