package com.api.employeedepartment_onetomany.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class EmployeeDto {

    @NotBlank
    private String email;

    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phone;

    @NotBlank
    private UUID department;

    // Getters e Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getDepartment() {
        return department;
    }

    public void setDepartment(UUID department) {
        this.department = department;
    }
}
