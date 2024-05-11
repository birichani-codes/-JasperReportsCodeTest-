package birichani.code.Jasperreportstest.service;

import birichani.code.Jasperreportstest.entity.Employee;
import birichani.code.Jasperreportstest.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project_name: Jasper-reports-test
 * Entity_name: EmployeeService
 * Author: @birichani_codes
 * IDE: IntelliJ IDEA
 * Date: 10 May 2024
 * Time: 19:08
 */
@Service
public class ReportService {
    @Autowired
    private EmployeeRepository repository;
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\USER\\Desktop\\Jasper-Report";
        List<Employee> employees = repository.findAll();

        // Load main report file and compile it
        File mainReportFile = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport mainJasperReport = JasperCompileManager.compileReport(mainReportFile.getAbsolutePath());

      // Load subreport file and compile it
        File subReportFile = ResourceUtils.getFile("classpath:EmployeeDetailsSubreport.jrxml");
        JasperReport subJasperReport = JasperCompileManager.compileReport(subReportFile.getAbsolutePath());

        JRBeanCollectionDataSource mainDataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "birichani");
        parameters.put("SubreportParameter", subJasperReport);

        JasperPrint jasperPrint = JasperFillManager.fillReport(mainJasperReport, parameters, mainDataSource);

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\EmployeeReport.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\EmployeeReport.pdf");
        }

        return "Report generated in path: " + path;
    }

}

