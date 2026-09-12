package dto;

public class SalaryStatistics {

    private double averageSalaryOfAllEmployees;
    private double highestSalary;
    private double lowestSalary;
    private double totalSalaryOfAllEmployees;

    public double isAverageSalaryOfAllEmployees() {
        return averageSalaryOfAllEmployees;
    }

    public void setAverageSalaryOfAllEmployees(double averageSalaryOfAllEmployees) {
        this.averageSalaryOfAllEmployees = averageSalaryOfAllEmployees;
    }

    public double isHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(double highestSalary) {
        this.highestSalary = highestSalary;
    }

    public double isLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(double lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public double isTotalSalaryOfAllEmployees() {
        return totalSalaryOfAllEmployees;
    }

    public void setTotalSalaryOfAllEmployees(double totalSalaryOfAllEmployees) {
        this.totalSalaryOfAllEmployees = totalSalaryOfAllEmployees;
    }

    @Override
    public String toString() {
        return "SalaryStatistics{" +
                "averageSalaryOfAllEmployees=" + averageSalaryOfAllEmployees +
                ", highestSalary=" + highestSalary +
                ", lowestSalary=" + lowestSalary +
                ", totalSalaryOfAllEmployees=" + totalSalaryOfAllEmployees +
                '}';
    }
}
