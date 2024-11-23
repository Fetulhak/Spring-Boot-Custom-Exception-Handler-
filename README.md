# Spring Boot Global Exception Handling with `@ControllerAdvice`

This project demonstrates how to implement global exception handling in a Spring Boot application using the `@ControllerAdvice` annotation. It showcases custom exception handling by defining a centralized mechanism for managing exceptions across the application.

## Features
- Centralized exception handling using `@ControllerAdvice`
- Custom exception classes (`CustomerNotFoundException`)
- ResponseEntity customization for HTTP responses
- RESTful API endpoints for managing customers

---

## Project Structure

The project follows a simple structure that separates the controller, entity, and exception-related files for better organization and maintainability:


### Key Components

1. **CustomerController**  
   - This class provides endpoints for retrieving all customers and individual customers by their ID.
   - If a requested customer is not found, it throws a `CustomerNotFoundException`.

2. **GlobalExceptionHandler**  
   - The class uses the `@ControllerAdvice` annotation to define a global exception handler.
   - It captures any `CustomerNotFoundException` thrown by the controller and returns a structured exception response (in the form of an `ExceptionObject`).

3. **ExceptionObject**  
   - This class represents the structure of the exception response. It contains:
     - `message`: The error message describing what went wrong.
     - `timestamp`: The time when the error occurred.
     - `httpStatus`: The HTTP status code associated with the error (e.g., `NOT_FOUND`).

4. **CustomerNotFoundException**  
   - A custom exception class used to represent when a customer is not found in the system.

---

## APIs

### Get All Customers  
**Endpoint**: `/customers/all`  
**Method**: `GET`

This endpoint retrieves a list of all customers in the system.

### Get Customer by ID  
**Endpoint**: `/customers/get/{customerId}`  
**Method**: `GET`

This endpoint retrieves a customer by their ID. If the customer with the given ID is not found, it will throw a `CustomerNotFoundException` and return a custom error response.

---

## How It Works

1. **CustomerController** provides the REST API for fetching customer data.  
    - `GET /customers/all`: Returns a list of all customers.  
    - `GET /customers/get/{customerId}`: Fetches a specific customer by their ID.

2. **GlobalExceptionHandler** captures exceptions like `CustomerNotFoundException` and returns an error response containing:
    - `message`: The error message explaining the issue.
    - `timestamp`: The time the error occurred.
    - `httpStatus`: The HTTP status code (e.g., `404 NOT_FOUND`).

3. **ExceptionObject** is the structure for the exception response, making it easy to return consistent and informative error details in case of an exception.

---

## Example Usage

1. **Fetch All Customers**  
   To fetch all customers, make a `GET` request to `/customers/all`. The response will return a list of customers in JSON format.

2. **Fetch Customer by ID**  
   To fetch a customer by ID, make a `GET` request to `/customers/get/{customerId}`. If the customer is found, their details will be returned. If not, an error response will be returned indicating that the customer is not found.

---

## Technologies Used
- **Spring Boot**: Framework for building the Java-based application.
- **Spring Web**: Module used to build RESTful web services.
- **Spring Data JPA**: Used for database interaction with the `Customer` entity.
- **Lombok**: Used to reduce boilerplate code like getters and setters.
- **JPA**: Used for ORM (Object-Relational Mapping) with the database.

---

## Conclusion

This project demonstrates the use of Spring Boot’s `@ControllerAdvice` to handle exceptions globally. By centralizing exception handling in one place, it ensures consistent error responses and simplifies debugging. This setup allows for a more maintainable codebase by separating concerns and ensuring that error handling is both reusable and extensible.
