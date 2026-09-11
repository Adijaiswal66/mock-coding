import entity.Employee;

import java.util.Arrays;

import static service.EmployeeService.*;

public class Main {


    public static void main(String[] args) {
        Employee employee1 = new Employee(1L, "Aditya", 600000, 4, "IT", 4);

        Employee employee2 = new Employee(2L, "Rahul", 450000, 5, "HR", 6);

        Employee employee3 = new Employee(3L, "Priya", 800000, 3, "IT", 3);

        Employee employee4 = new Employee(4L, "Amit", 300000, 2, "Finance", 2);

        Employee employee5 = new Employee(5L, "Sneha", 1000000, 5, "IT", 7);

        Employee[] employees = {employee1, employee2, employee3, employee4, employee5};

        double totalBonusOfITDepartment = 0;

        for (Employee employee : employees) {
            calculateTotalBonus(employee);
            if (employee.getDepartment().equals("IT")) {
                totalBonusOfITDepartment += totalBonusOfSelectedDepartment("IT", employee);
            }
        }


        Employee existingEmployee = getEmployeeById(1, employees);
        if (existingEmployee != null) {
            System.out.println("Found employee: " + existingEmployee);
        } else {
            System.out.println("Unable to find employee with this id");
        }

        System.out.println(Arrays.toString(removeEmployeeByEmployeeId(2, employees)));

//        updateEmployeeSalaryByEmployeeId(employees, 2L, 2000);
//
//        System.out.println(findHighestPaidEmployee(employees));
//
//        System.out.println("Total bonus of IT department : " + totalBonusOfITDepartment);
    }
}