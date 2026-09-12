package dto;

public class SalaryStatistics {

    private double averageSalaryOfAllEmployees;
    private double highestSalary;
    private double lowestSalary;
    private double totalSalaryOfAllEmployees;

    public double getAverageSalaryOfAllEmployees() {
        return averageSalaryOfAllEmployees;
    }

    public void setAverageSalaryOfAllEmployees(double averageSalaryOfAllEmployees) {
        this.averageSalaryOfAllEmployees = averageSalaryOfAllEmployees;
    }

    public double getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(double highestSalary) {
        this.highestSalary = highestSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(double lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public double getTotalSalaryOfAllEmployees() {
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
