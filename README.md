# Mock Coding — Spring Boot

This project is being evolved from Java collection exercises into a production-style Java backend.

## Run

```bash
mvn spring-boot:run
```

## Current endpoints

- `GET /api/employees`
- `GET /api/employees/{employeeId}`
- `GET /api/employees/performance`

The repository is currently in-memory. PostgreSQL/JPA will be introduced in a later task.

## Architecture

Controller → Service → Repository

Business logic stays in the service layer. The repository owns employee data access.
