package ru.sbt.javaschool.refactoring.reportnotifier;

import java.time.LocalDate;

/**
 * Created by Никита on 15.09.2016.
 */
public class SalaryOfEmployee {
    private final int empId;
    private final String empName;
    private final double salary;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public SalaryOfEmployee(int empId, String empName, double salary, LocalDate dateFrom, LocalDate dateTo) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }
}
