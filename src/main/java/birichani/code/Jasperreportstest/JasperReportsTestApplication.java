package birichani.code.Jasperreportstest;

import birichani.code.Jasperreportstest.entity.Employee;
import birichani.code.Jasperreportstest.repository.EmployeeRepository;
import birichani.code.Jasperreportstest.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class JasperReportsTestApplication {
	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private ReportService service;

	/**
	 * Endpoint to fetch all employees from the database.
	 * @return A list of all employees.
	 */
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = repository.findAll();
		return ResponseEntity.ok(employees);  // Return the list of employees with a status code of 200
	}

	/**
	 * Endpoint to generate a report in a specified format with optional parameters.
	 * @param format The format of the report (e.g., pdf, html).
	 * @param department The department to filter by.
	 * @param minSalary The minimum salary threshold.
	 * @param maxSalary The maximum salary threshold.
	 * @return A response message indicating the result of the report generation.
	 * @throws FileNotFoundException if the report file is not found.
	 * @throws JRException if there is an error during report generation.
	 */
	@GetMapping("/report/{format}")
	public ResponseEntity<String> generateReport(@PathVariable String format) {
		try {
			String reportUrl = service.exportReport(format);
			return ResponseEntity.ok("Report generated successfully. Download from: " + reportUrl);
		} catch (FileNotFoundException | JRException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Failed to generate report: " + e.getMessage());
		}
	}




	public static void main(String[] args) {
		SpringApplication.run(JasperReportsTestApplication.class, args);
	}

}
