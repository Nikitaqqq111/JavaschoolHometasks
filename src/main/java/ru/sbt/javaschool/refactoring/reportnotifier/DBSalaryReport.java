package ru.sbt.javaschool.refactoring.reportnotifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Никита on 16.09.2016.
 */
public class DBSalaryReport {

    private Connection connection;

    private final String query;
    private final String departmentId;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public DBSalaryReport(Connection databaseConnection, String query, String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        connection = databaseConnection;
        this.query = query;
        this.departmentId = departmentId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }


    public SalaryReport executeQuery() {
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));
            ResultSet results = ps.executeQuery();
            return parseResultSet(results);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException from DBSalaryReport, problem with Database", e);
        }
    }

    private SalaryReport parseResultSet(ResultSet resultSet) {
        try {
            SalaryReport SalaryReport = new SalaryReport(dateFrom, dateTo);
            while (resultSet.next()) {
                SalaryOfEmployee salaryOfEmployee = new SalaryOfEmployee(resultSet.getInt("emp_id"), resultSet.getString("emp_name"), resultSet.getDouble("salary"), dateFrom, dateTo);
                SalaryReport.addSalaryOfEmployee(salaryOfEmployee);
            }
            return SalaryReport;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException from DBSalaryReport, problem with Database", e);
        }

    }
}
