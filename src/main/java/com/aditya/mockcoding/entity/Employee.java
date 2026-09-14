package com.aditya.mockcoding.entity;

public class Employee {

    private Long employeeId;
    private String employeeName;
    private double salary;
    private int rating;
    private String department;
    private int yearsOfExperience;
    private double employeeBonus;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, double salary, int rating,
                     String department, int yearsOfExperience) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.rating = rating;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Employee(Employee employee) {
        this.employeeId = employee.employeeId;
        this.employeeName = employee.employeeName;
        this.salary = employee.salary;
        this.rating = employee.rating;
        this.department = employee.department;
        this.yearsOfExperience = employee.yearsOfExperience;
        this.employeeBonus = employee.employeeBonus;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public double getEmployeeBonus() { return employeeBonus; }
    public void setEmployeeBonus(double employeeBonus) { this.employeeBonus = employeeBonus; }
}
