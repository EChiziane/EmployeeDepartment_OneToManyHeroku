package com.api.employeedepartment_onetomany.dtos;

import jakarta.validation.constraints.NotBlank;

public class DepartmentDto {
    @NotBlank
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
