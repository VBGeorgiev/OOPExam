package com.oopexam.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String role;
    private double salary;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employee(int id, String name, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.startDate = LocalDate.now();
        this.endDate = null;
    }

    public Employee(int id, String name, String department, String role, double salary, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void view() {
        System.out.println(this.id + ", " + this.name + ", " + this.startDate + ", " +
                this.endDate + ", " + this.role + ", " + this.department + ", " + this.salary);
    }
}
