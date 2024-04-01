package api.controller;

import service.VacationCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * Controller class to handle HTTP requests related to vacation calculations.
 */
@RestController
@Validated
public class VacationController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    /**
     * Method to handle HTTP GET request for calculating vacation allowance.
     *
     * @param averageSalary    the average salary for the employee
     * @param vacationDays     the number of vacation days requested
     * @param vacationStartDate the start date of the vacation
     * @param vacationEndDate   the end date of the vacation
     * @return the calculated vacation allowance
     */
    @GetMapping("/calculate")
    public double calculateVacationAllowance(
            @RequestParam @Min(0) double averageSalary,
            @RequestParam @Min(0) @Max(365) int vacationDays,
            @RequestParam(required = false) LocalDate vacationStartDate,
            @RequestParam(required = false) LocalDate vacationEndDate) {

        if (vacationStartDate != null && vacationEndDate != null) {
            return vacationCalculatorService.calculateWithCustomDates(averageSalary, vacationDays, vacationStartDate, vacationEndDate);
        } else {
            return vacationCalculatorService.calculateWithoutCustomDates(averageSalary, vacationDays);
        }
    }

    /**
     * Exception handler method to handle validation exceptions.
     *
     * @param ex      the exception to handle
     * @param request the web request
     * @return the ResponseEntity with the error message and status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}