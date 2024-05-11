package birichani.code.Jasperreportstest.repository;

import birichani.code.Jasperreportstest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartmentAndSalaryBetween(String department, double minSalary, double maxSalary);

}
