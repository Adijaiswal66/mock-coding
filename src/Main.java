import entity.Employee;

import java.util.List;

import static service.EmployeeService.filterEmployeeByDepartment;

public class Main {


    public static void main(String[] args) {
        Employee employee1 = new Employee(1L, "Aditya", 600000, 4, "IT", 4);

        Employee employee2 = new Employee(2L, "Rahul", 450000, 5, "HR", 6);

        Employee employee3 = new Employee(3L, "Priya", 800000, 3, "IT", 3);

        Employee employee4 = new Employee(4L, "Amit", 300000, 2, "Finance", 2);

        Employee employee5 = new Employee(5L, "Sneha", 1000000, 5, "IT", 7);

        Employee[] employees = {employee1, employee2, employee3, employee4, employee5};

        List<Employee> employeeList = filterEmployeeByDepartment(employees, "IT");
        if (employeeList.isEmpty()) {
            System.out.println("No Employee found!");
        } else {
            System.out.println(employeeList);
        }

    }
}