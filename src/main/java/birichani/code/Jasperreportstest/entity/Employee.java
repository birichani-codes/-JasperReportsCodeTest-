package birichani.code.Jasperreportstest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Project_name: Jasper-reports-test
 * Entity_name: Employee
 * Author: @birichani_codes
 * IDE: IntelliJ IDEA
 * Date: 10 May 2024
 * Time: 19:06
 */
@Entity
public class Employee {
    @Id
    private int id; // Keep Employee ID

    private String name; // Change to Employee Name

    private String department; // Change to Department

    private double salary; // Keep Salary

    private String hireDate; // Change to Hire Date

    public Employee(int id, String name, String department, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }
}

