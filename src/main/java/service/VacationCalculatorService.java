package service;

import util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Service class to perform vacation allowance calculations.
 */
@Service
public class VacationCalculatorService {

    /**
     * Method to calculate vacation allowance without custom dates.
     *
     * @param averageSalary the average salary for the employee
     * @param vacationDays  the number of vacation days requested
     * @return the calculated vacation allowance
     */
    public double calculateWithoutCustomDates(double averageSalary, int vacationDays) {
        LoggerUtil.info("Calculating vacation allowance without custom dates");
        return averageSalary * vacationDays / 365;
    }

    /**
     * Method to calculate vacation allowance with custom dates.
     *
     * @param averageSalary    the average salary for the employee
     * @param vacationDays     the number of vacation days requested
     * @param vacationStartDate the start date of the vacation
     * @param vacationEndDate   the end date of the vacation
     * @return the calculated vacation allowance
     */
    public double calculateWithCustomDates(double averageSalary, int vacationDays, LocalDate vacationStartDate, LocalDate vacationEndDate) {
        LoggerUtil.info("Calculating vacation allowance with custom dates");
        if (vacationStartDate != null && vacationEndDate != null) {
            long workDays = ChronoUnit.DAYS.between(vacationStartDate, vacationEndDate) + 1;
            return averageSalary * workDays / 365;
        } else {
            throw new IllegalArgumentException("Vacation start date and end date must be provided.");
        }
    }

    /**
     * Method to calculate the number of work days between two dates, excluding weekends and holidays.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the number of work days
     */
    private long calculateWorkDays(LocalDate startDate, LocalDate endDate) {
        LoggerUtil.info("Calculating work days between dates");
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        long weekends = calculateWeekends(startDate, endDate);
        return totalDays - weekends;
    }

    /**
     * Method to calculate the number of weekends between two dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the number of weekends
     */
    private long calculateWeekends(LocalDate startDate, LocalDate endDate) {
        LoggerUtil.info("Calculating weekends between dates");
        long saturdays = ChronoUnit.DAYS.between(startDate, endDate.plusDays(1)) / 7;
        long sundays = ChronoUnit.DAYS.between(startDate.plusDays(6), endDate.plusDays(1)) / 7;
        return saturdays + sundays;
    }
}