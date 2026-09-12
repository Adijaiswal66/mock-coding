package dto;

public class DepartmentSummary {

    private int employeeCount;
    private double totalSalary;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public DepartmentSummary(int employeeCount, double totalSalary) {
        this.employeeCount = employeeCount;
        this.totalSalary = totalSalary;
    }

    public DepartmentSummary() {
    }

    @Override
    public String toString() {
        return "DepartmentSummary{" +
                "employeeCount=" + employeeCount +
                ", totalSalary=" + totalSalary +
                '}';
    }
}
