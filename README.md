# Vacation Calculator

The Vacation Calculator is a Java application that calculates vacation days based on custom rules and criteria.

### Overview

The application provides RESTful endpoints to interact with the vacation calculation service. Users can input their custom criteria such as start date, end date, and other parameters to calculate the total number of vacation days.

### Features

* Calculate vacation days based on custom criteria.
* RESTful API endpoints for easy integration with other systems.
* Input validation to ensure accurate calculations.
* Unit tests to validate the functionality of the calculation service.

### Technologies Used

* Java 11
* Spring Boot
* Maven
* Logback for logging
* 
### Project Description

The Vacation Calculator project is a Spring Boot application designed to calculate vacation days based on provided criteria. Below is a brief description of the main classes in the project:

1. **VacationCalculatorApplication**: This class contains the main method to run the Spring Boot application. It initializes the Spring ApplicationContext and starts the embedded web server.

2. **VacationCalculatorService**: This service class contains the core business logic for calculating vacation days. It provides methods to calculate vacation days based on different criteria such as start date, end date, and employee type.

3. **VacationCalculatorController**: This controller class defines REST endpoints for interacting with the vacation calculation functionality. It handles incoming HTTP requests, invokes the corresponding methods in the service layer, and returns appropriate responses.

4. **Exception**: This package contains custom exception classes used in the application. It helps to handle and propagate exceptions in a structured manner.

5. **LoggerUtil**: This utility class provides methods for logging messages at different levels (e.g., info, debug, error). It is used for logging application events and errors.

6. **api**: This package contains DTO (Data Transfer Object) classes used for request and response payloads in REST endpoints. These classes define the structure of data exchanged between the client and the server.

7. **util**: This package contains utility classes used across the application for various purposes such as date manipulation, string formatting, etc.


### Build and Run

1. Clone the repository.
2. Open the project in your favorite Java IDE.
3. Run the VacationCalculatorApplication class to start the application.