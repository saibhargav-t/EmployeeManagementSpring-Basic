# Employee Management System - Spring Boot Tutorial

A comprehensive Spring Boot tutorial demonstrating multiple approaches to building REST APIs for employee management. This project is intended for beginners to understand different implementation strategies in Spring Boot.

## Overview

This project demonstrates several ways to implement a simple Employee Management System using different Spring Boot features and patterns:

1. **Traditional Controller-Service-Repository Pattern**
   - REST Controllers with `@RestController`
   - Service layer with `@Service`
   - Repository layer with Spring Data JPA

2. **General DAO Pattern**
   - Using a generic DAO implementation

3. **Spring Data REST**
   - Automatically exposing repositories as RESTful services

By exploring these different approaches within the same codebase, beginners can understand the trade-offs and benefits of each approach.

## Technology Stack

- Java 24
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL Database
- Maven
- Spring Data REST

## Project Structure

```
├── src/main/java/com/luv2code/springboot/cruddemo/
│   ├── CruddemoApplication.java               # Main application class
│   ├── dao/                                   # Data Access Objects
│   │   ├── EmployeeDAO.java                   # DAO interface
│   │   └── EmployeeDAOJpaImpl.java            # JPA implementation of DAO
│   ├── entity/
│   │   └── Employee.java                      # Employee entity class
│   ├── rest/
│   │   └── EmployeeRestController.java        # REST controller with traditional approach
│   ├── service/
│   │   ├── EmployeeService.java               # Service interface
│   │   └── EmployeeServiceImpl.java           # Service implementation
│   └── repository/
│       └── EmployeeRepository.java            # Spring Data JPA repository
```

## Request-Response Lifecycle

### Traditional Controller-Service-Repository Pattern

```
Client Request → REST Controller → Service → Repository → Database
                                                 ↑
Response ← REST Controller ← Service ← Repository ↓
```

### Spring Data REST Approach

```
Client Request → Spring Data REST → Repository → Database
                                        ↑
Response ← Spring Data REST ← Repository ↓
```

## Implementation Details

### 1. Employee Entity

The `Employee` class is a JPA entity that maps to the `employee` table in the database:

### 2. Traditional Approach with DAO

#### EmployeeDAO Interface

```java
public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
```

#### EmployeeDAOJpaImpl Implementation

```java
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;
    
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Employee> findAll() {
        // Implementation using JPA
    }
    
    // Other method implementations
}
```

### 3. Service Layer

#### EmployeeService Interface

```java
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
```

#### EmployeeServiceImpl Implementation

```java
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
    
    // Other method implementations
}
```

### 4. REST Controller

```java
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    
    // Other endpoint implementations
}
```

### 5. Spring Data JPA Repository

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Spring Data JPA provides all basic CRUD operations automatically
    // Custom queries can be added here
}
```

### 6. Spring Data REST

By adding the Spring Data REST dependency and proper configuration, repository interfaces are automatically exposed as RESTful endpoints:

```properties
# application.properties
spring.data.rest.base-path=/api
```

## API Endpoints

### Traditional REST Controller

- `GET /api/employees` - Get all employees
- `GET /api/employees/{id}` - Get employee by ID
- `POST /api/employees` - Create new employee
- `PUT /api/employees/{id}` - Update employee
- `DELETE /api/employees/{id}` - Delete employee

### Spring Data REST (automatically generated)

- `GET /api/employees` - Get all employees
- `GET /api/employees/{id}` - Get employee by ID
- `POST /api/employees` - Create new employee
- `PUT /api/employees/{id}` - Update employee
- `DELETE /api/employees/{id}` - Delete employee
- `GET /api/employees?page=0&size=20` - Pagination support
- `GET /api/employees?sort=lastName,desc` - Sorting support

Note: Use Postman, Curl or other tools to expose these API's.

## Key Differences Between Approaches

### Traditional Controller-Service-Repository
- More control over the request/response cycle
- Custom business logic in the Service layer
- Explicit implementation of endpoints
- More verbose but clearer separation of concerns

### Spring Data REST
- Minimal code (almost zero boilerplate)
- Automatic CRUD endpoints
- Built-in pagination, sorting, and HATEOAS
- Less control but faster development

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL

### Database Setup
1. Create a MySQL database named `employee_directory`
2. Update `application.properties` with your database credentials

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Running the Application
1. Clone this repository
   ```bash
   git clone https://github.com/saibhargav-t/EmployeeManagementSpring-Basic.git
   ```

2. Navigate to the project directory
   ```bash
   cd EmployeeManagementSpring-Basic
   ```

3. Build the project
   ```bash
   mvn clean install
   ```

4. Run the application
   ```bash
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:8080/api/employees`

## Learning Resources

For beginners looking to understand these concepts better:

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Spring Data REST Documentation](https://docs.spring.io/spring-data/rest/docs/current/reference/html/)

## Author

- [Sai Bhargav T](https://github.com/saibhargav-t)
