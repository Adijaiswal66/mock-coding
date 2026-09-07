package service;

import entity.Employee;

public class EmployeeService {

    public static void calculateTotalBonus(Employee employee) {
        double annualSalary = employee.getSalary();
        int rating = employee.getRating();
        boolean yearsOfExperience = employee.getYearsOfExperience() >= 5;
        boolean isEligibleForBonus = (annualSalary >= 400000) && (rating >= 3);
        double bonus = 0;

        if (isEligibleForBonus) {
            if (rating == 5) {
                bonus = annualSalary * 0.20;
            } else if (rating == 4) {
                bonus = annualSalary * 0.15;
            } else if (rating == 3) {
                bonus = annualSalary * .10;
            } else {
                System.out.println("Invalid rating");
            }
            if (yearsOfExperience) {
                bonus += 25000;
            }
        }
        employee.setEmployeeBonus(bonus);

        System.out.println("Department: " + employee.getDepartment() + " Employee with ID: " + employee.getEmployeeId() + "-> Salary " + employee.getSalary() + ", Rating: " + employee.getRating() + "Eligible: " + isEligibleForBonus + ", Bonus: " + bonus);
    }

    public static double totalBonusOfSelectedDepartment(String department, Employee employee) {
        double totalBonus = 0;

        if (department.equals("IT")) {
            totalBonus += employee.getEmployeeBonus();
        }
        return totalBonus;
    }

//    public static boolean checkEligibilityForBonus(double salary, int rating) {
//        return (salary >= 400000) && (rating >= 3);
//    }

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
