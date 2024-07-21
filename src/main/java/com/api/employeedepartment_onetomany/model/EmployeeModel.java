package com.api.employeedepartment_onetomany.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_EMPLOYEE")
public class EmployeeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

    @Column(nullable = false)
    private String phone;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
