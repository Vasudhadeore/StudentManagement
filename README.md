# Student Management System

A RESTful Student Management API developed using Java and Spring Boot. The application provides APIs to create, retrieve, update, and delete student records using PostgreSQL as the database.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST API
- Jakarta Validation
- Lombok
- IntelliJ IDEA
- Postman

## Features

- Create a new student
- Get all students
- Get student by ID
- Update student details
- Delete student
- Pagination
- Request validation
- Global exception handling
- Standardized API responses
- PostgreSQL database integration

## Project Architecture

```text
Client / Postman
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
PostgreSQL Database

The project follows a layered architecture:
- Controller
- Service
- Repository
- Entity
- DTO
- Mapper
- Exception Handling

API Endpoints
Method	       Endpoint	            Description
POST	   /api/students	      Create a student
GET	       /api/students	      Get all students
GET	       /api/students/{id}	  Get student by ID
PUT	       /api/students/{id}     Update student
DELETE	   /api/students/{id}	  Delete student

Pagination
Students can be retrieved using pagination:GET /api/students?page=0&size=10

Validation
The application validates incoming student data including:
- Name
- Email
- Phone number
- Age
- Course
- City
Invalid data returns a 400 Bad Request response.

Exception Handling
Global exception handling is implemented using @RestControllerAdvice.
For example, when a student does not exist:
{
  "code": "NOT_FOUND",
  "message": "Student not found with id: 999",
  "status": 404
}

Database
The application uses PostgreSQL.
Database name:students
The database password is not stored in the GitHub repository. It is provided through the DB_PASSWORD environment variable.
How to Run
1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Make sure PostgreSQL is installed and running.
4. Create a database named students.
5. Configure the DB_PASSWORD environment variable.
6. Run StudentManagementApplication.
7. Use Postman to test the REST APIs.


Project Status
Completed backend REST API with CRUD operations, validation, pagination, PostgreSQL integration, standardized responses, and global exception handling.