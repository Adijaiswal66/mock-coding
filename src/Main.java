import entity.Employee;

import static service.EmployeeService.*;

public class Main {


    public static void main(String[] args) {
        Employee employee1 = new Employee(1L, "Aditya", 600000, 4, "IT", 4);

        Employee employee2 = new Employee(2L, "Rahul", 450000, 5, "HR", 6);

        Employee employee3 = new Employee(3L, "Priya", 800000, 3, "IT", 3);

        Employee employee4 = new Employee(4L, "Amit", 300000, 2, "Finance", 2);

        Employee employee5 = new Employee(5L, "Sneha", 1000000, 5, "IT", 7);

        Employee[] employees = {employee1, employee2, employee3, employee4, employee5};

        double totalBonus = 0;


        for (Employee employee : employees) {
            boolean isEligibleForBonus = checkEligibilityForBonus(employee.getSalary(), employee.getRating());
            boolean isEligibleForExperienceBonus = calculateExperienceBonus(employee);
            double bonus = 0.00;
            if (isEligibleForBonus) {
                bonus = calculateBonus(employee.getSalary(), employee.getRating());
                if (isEligibleForExperienceBonus) {
                    bonus += 25000;
                }
            }
            System.out.println("Department: " + employee.getDepartment() + " entity.Employee with ID: " + employee.getEmployeeId() + "-> Salary " + employee.getSalary() + ", Rating: " + employee.getRating() + "Eligible: " + isEligibleForBonus + ", Bonus: " + bonus);

            if (employee.getDepartment().equals("IT")) {
                totalBonus += bonus;
            }
        }
        System.out.println(findHighestPaidEmployee(employees));
        System.out.println("Total bonus of IT department : " + totalBonus);
    }
}