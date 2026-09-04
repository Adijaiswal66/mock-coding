package service;

import entity.Employee;

public class EmployeeService {

    public static double calculateBonus(double annualSalary, int rating) {
        double bonus = 0;
        if (rating == 5) {
            bonus = annualSalary * 0.20;
        } else if (rating == 4) {
            bonus = annualSalary * 0.15;
        } else if (rating == 3) {
            bonus = annualSalary * .10;
        } else if (rating == 2) {
            bonus = annualSalary * 0.05;
        } else {
            System.out.println("Invalid rating");
        }
        return bonus;
    }

    public static boolean checkEligibilityForBonus(double salary, int rating) {
        return (salary >= 400000) && (rating >= 3);
    }

    public static Employee findHighestPaidEmployee(Employee[] employees) {
        Employee maxSalaryEmp = employees[0];
        for (Employee employee : employees) {
            if (maxSalaryEmp.getSalary() < employee.getSalary()) {
                maxSalaryEmp = employee;
            }
        }
        return maxSalaryEmp;
    }

    public static void findEmployeesByDepartment(Employee[] employees, String department) {
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                employeeFound = true;
                System.out.println(employee);
            }
        }
        if (!employeeFound) {
            System.out.println("No employees found !");
        }
    }

}
