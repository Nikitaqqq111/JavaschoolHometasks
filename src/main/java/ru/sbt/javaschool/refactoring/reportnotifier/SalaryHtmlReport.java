package ru.sbt.javaschool.refactoring.reportnotifier;

/**
 * Created by Никита on 16.09.2016.
 */
public class SalaryHtmlReport {

    public String createReport(SalaryReport salaryReport) {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        for (SalaryOfEmployee salaryOfEmployee : salaryReport.getReport()) {
            resultingHtml.append("<tr>");
            resultingHtml.append("<td>").append(salaryOfEmployee.getEmpName()).append("</td>");
            resultingHtml.append("<td>").append(salaryOfEmployee.getSalary()).append("</td>");
            resultingHtml.append("</tr>");
            totals += salaryOfEmployee.getSalary();
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml.toString();
    }

}
