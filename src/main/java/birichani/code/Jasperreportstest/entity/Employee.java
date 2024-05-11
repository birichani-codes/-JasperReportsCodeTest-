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
    private int id; // Employee ID

    private String name; // Employee Name

    private String department; // Department

    private double salary; // Salary

    private String hireDate; // Hire Date

    private String address; // Address of the Employee

    private String contact_info; // Contact Information of the Employee

    public Employee(int id, String name, String department, double salary, String hireDate, String address, String contact_info) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
        this.address = address;
        this.contact_info = contact_info;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContactInfo(String contact_info) {
        this.contact_info = contact_info;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                ", address='" + address + '\'' +
                ", contactInfo='" + contact_info + '\'' +
                '}';
    }
}

