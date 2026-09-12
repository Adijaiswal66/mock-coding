package dto;

import java.util.Map;

public class DashboardSummary {

//    private Map<String, Integer> departmentWiseEmployeeCount;
//    private Map<String, Double> departmentWiseTotalSalary;
//
//    public Map<String, Integer> getDepartmentWiseEmployeeCount() {
//        return departmentWiseEmployeeCount;
//    }
//
//    public void setDepartmentWiseEmployeeCount(Map<String, Integer> departmentWiseEmployeeCount) {
//        this.departmentWiseEmployeeCount = departmentWiseEmployeeCount;
//    }
//
//    public Map<String, Double> getDepartmentWiseTotalSalary() {
//        return departmentWiseTotalSalary;
//    }
//
//    public void setDepartmentWiseTotalSalary(Map<String, Double> departmentWiseTotalSalary) {
//        this.departmentWiseTotalSalary = departmentWiseTotalSalary;
//    }
//
//    @Override
//    public String toString() {
//        return "DashboardSummary{" +
//                "departmentWiseEmployeeCount=" + departmentWiseEmployeeCount +
//                ", departmentWiseTotalSalary=" + departmentWiseTotalSalary +
//                '}';
//    }

    private int employeeCount;
    private double employeeSalary;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public DashboardSummary(int employeeCount, double employeeSalary) {
        this.employeeCount = employeeCount;
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "DashboardSummary{" +
                "employeeCount=" + employeeCount +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
