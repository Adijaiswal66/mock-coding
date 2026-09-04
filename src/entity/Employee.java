package entity;

public class Employee {
    private Long employeeId;
    private String employeeName;
    private double salary;
    private int rating;
    private String department;
    private int yearsOfExperience;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Employee(Long employeeId, String employeeName, double salary, int rating, String department, int yearsOfExperience) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.rating = rating;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "entity.Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                ", department='" + department + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
