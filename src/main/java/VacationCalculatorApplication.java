import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application class to run the Vacation Calculator application.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"api", "controller", "exception", "service", "util"})
public class VacationCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationCalculatorApplication.class, args);
    }
}