package ru.sbt.javaschool.refactoring.reportnotifier;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Никита on 15.09.2016.
 */
public class SalaryReport {

    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    private final Set<SalaryOfEmployee> report = new HashSet<>();

    public SalaryReport(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public boolean addSalaryOfEmployee(SalaryOfEmployee salaryOfEmployee) {
        if (!(salaryOfEmployee.getDateFrom().equals(dateFrom) && salaryOfEmployee.getDateTo().equals(dateTo)))
            return false;
        report.add(salaryOfEmployee);
        return true;
    }

    public Set<SalaryOfEmployee> getReport() {
        return report;
    }
}
