package ru.sbt.javaschool.refactoring.reportnotifier;

import java.sql.Connection;
import java.time.LocalDate;

/**
 * Created by Никита on 16.09.2016.
 */
public class SalaryHtmlReportNotifier {
    private Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        String query = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? group by emp.id, emp.name";
        DBSalaryReport dbSalaryReport = new DBSalaryReport(connection, query, departmentId, dateFrom, dateTo);
        SalaryHtmlReport salaryHtmlReport = new SalaryHtmlReport();
        String report = salaryHtmlReport.createReport(dbSalaryReport.executeQuery());
        Sender.send("mail.google.com", "Monthly department salary report", report, recipients);
    }
}
