import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import service.VacationCalculatorService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacationCalculatorServiceTest {

    @InjectMocks
    private VacationCalculatorService vacationCalculatorService;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculateWithoutCustomDates() {
        double averageSalary = 50000;
        int vacationDays = 20;
        double expectedAllowance = averageSalary * vacationDays / 365;
        double actualAllowance = vacationCalculatorService.calculateWithoutCustomDates(averageSalary, vacationDays);
        assertEquals(expectedAllowance, actualAllowance);
    }

    @Test
    void calculateWithCustomDates() {
        double averageSalary = 50000;
        int vacationDays = 20;
        LocalDate startDate = LocalDate.now().minus(10, ChronoUnit.DAYS);
        LocalDate endDate = LocalDate.now().plus(10, ChronoUnit.DAYS);
        long workDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        double expectedAllowance = averageSalary * workDays / 365;
        double actualAllowance = vacationCalculatorService.calculateWithCustomDates(averageSalary, vacationDays, startDate, endDate);
        assertEquals(expectedAllowance, actualAllowance);
    }
}