package com.demirtag.intranet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_detail_id")
    private EmployeeDetail employeeDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacation_days_id")
    private VacationDays vacationDays;

    @OneToMany(mappedBy = "employee"
            , cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Holiday> holidays;

    public Employee() {
    }

    public Employee(String name, String lastName, String role) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
